package com.jcc.zookeeper;

import org.apache.commons.lang3.StringUtils;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @program: javaknowledge->ZKLockDemo
 * @description: 通过Zookeeper官方API自主实现分布式锁；
 * @author: jinchuanchuan1@le.com
 * @create: 2020-11-13 11:22
 **/
@Service
public class ZkLockDemo implements InitializingBean, Watcher {
    private static Logger logger = LoggerFactory.getLogger(ZkLockDemo.class);
    private static volatile ZooKeeper zk;
    static String zkAddress = "127.0.0.1:2181";

    /**
     * 根节点
     */
    private String root = "/locksNode";

    /**
     * 存储当前线程创建的锁(临时顺序节点的全路径)
     */
    private ThreadLocal<List<String>> nodePathList = new ThreadLocal<>();

    public ZkLockDemo() {
    }

    @Override
    public void afterPropertiesSet() {
        createRootNode();
    }

    /**
     * 创建锁的持久化根节点
     */
    private void createRootNode() {
        try {
            if (StringUtils.isBlank(zkAddress)) {
                throw new NullPointerException("zooKeeper address conf error");
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            //建立zk连接
            logger.info("开始连接zk", root);
            zk = new ZooKeeper(zkAddress, 10000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (event.getState() == Event.KeeperState.SyncConnected) {
                        countDownLatch.countDown();
                    }
                }
            });
            //等待锁连接成功
            countDownLatch.await(10, TimeUnit.SECONDS);
            if (zk == null) {
                throw new NullPointerException("zooKeeper connect failure");
            }
            Stat stat = zk.exists(root, true);
            if (stat == null) {
                //创建持久化根节点
                zk.create(root, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                logger.info("根节点{}创建完成", root);
            } else {
                logger.info("根节点{}已存在，直接使用", root);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 监听zk是否需要重连接
     * @param watchedEvent
     */
    @Override
    public void process(WatchedEvent watchedEvent) {
        try {
            //zk的session过期时，重新创建连接
            if (watchedEvent.getState() == Event.KeeperState.Expired) {
                logger.info("zk连接过期，重新创建连接");
                zk.close();
                zk = null;
                createRootNode();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建具体的锁节点
     *
     * @param lockPath
     */
    private void createLockNode(String lockPath) {
        try {
            //判断指定锁路径是否存在，若不存在则创建
            Stat stat = zk.exists(lockPath, true);
            if (stat == null) {
                //创建持久化锁节点
                zk.create(lockPath, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                logger.info("锁路径创建成功：{}", lockPath);
            } else {
                logger.info("锁路径已经存在：{}", lockPath);
            }
        } catch (KeeperException.NodeExistsException e) {
            logger.error("node节点已经存在，本次创建失败：{}", e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 阻塞锁
     * @param lockName 锁名
     */
    public void lock(String lockName) {
        try {
            //创建锁目录
            String lockPath = root + "/" + lockName;
            createLockNode(lockPath);

            //当前线程创建的临时顺序节点
            String clientLockNode = zk.create(lockPath + "/client", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

            //获取当前临时顺序节点的前一个节点，若获取的前置节点为null，则表示当前节点获取到锁
            String preNode=getPreNode(lockPath,clientLockNode);
            CountDownLatch latch = new CountDownLatch(1);
            if(preNode!=null){
                //注册监听
                Stat lockStat = zk.exists(preNode, new LockWatcher(latch,lockPath,clientLockNode));
                if (lockStat != null) {
                    // 等待
                    latch.await();
                    latch = null;
                    addLock(clientLockNode);
                    logger.info("阻塞线程锁获取成功，锁路径为：{}", clientLockNode);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取当前线程创建的临时顺序节点的前一个节点
     * @param lockPath 锁路径
     * @param clientLockNode 当前线程创建的临时顺序节点
     * @return 前一个临时顺序节点
     */
    private String getPreNode(String lockPath,String clientLockNode){
        String preNode=null;
        try {
            // 取出lockPath下所有子节点
            List<String> subNodes = zk.getChildren(lockPath, true);
            TreeSet<String> sortedNodes = new TreeSet<>();
            for (String node : subNodes) {
                sortedNodes.add(lockPath + "/" + node);
            }
            //获取最小临时顺序节点
            String minNode = sortedNodes.first();
            // 如果当前节点是最小节点,则表示取得锁
            if (clientLockNode.equals(minNode)) {
                addLock(clientLockNode);
                logger.info("锁获取成功，锁路径为：{}", clientLockNode);
            }else{
                //获取比当前节点小的最大节点进行监听
                preNode = sortedNodes.lower(clientLockNode);
                logger.info("阻塞等待获取锁，锁路径为：{}，监听的前置节点为：{}", clientLockNode, preNode);
            }
        }catch (Exception e){

        }
        return preNode;
    }

    /**
     * 监听临时顺序节点是否被删除
     */
    class LockWatcher implements Watcher {
        private CountDownLatch latch = null;
        private String lockPath = null;
        private String clientLockNode = null;
        public LockWatcher(CountDownLatch latch,String lockPath,String clientLockNode) {
            this.latch = latch;
            this.lockPath=lockPath;
            this.clientLockNode=clientLockNode;
        }
        @Override
        public void process(WatchedEvent event) {
            if (event.getType() == Event.EventType.NodeDeleted) {
                //若当前节点的前置节点被删除，需重新判断当前节点是否还存在前置节点
                //正常情况下前置节点删除，则表示当前节点获取锁
                //当前置节点没有获取锁，但是异常断连时，当前节点则需监听剩余的最大前置节点
                String preNode=getPreNode(lockPath,clientLockNode);
                if(preNode==null){
                    latch.countDown();
                }else{
                    try {
                        zk.exists(preNode, new LockWatcher(latch,lockPath,clientLockNode));
                    }catch (Exception e){

                    }
                }
            }
        }
    }

    /**
     * 尝试获取锁
     * @param lockName
     * @return
     */
    public boolean tryLock(String lockName) {
        try {
            //创建锁目录
            String lockPath = root + "/" + lockName;
            createLockNode(lockPath);
            //当前线程创建的临时顺序节点
            String clientLockNode = zk.create(lockPath + "/client", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            String preNode = getPreNode(lockPath, clientLockNode);
            // 如果当前节点是最小节点,则表示取得锁
            addLock(clientLockNode);
            if (preNode == null) {
                logger.info("锁获取成功，锁路径为：{}", clientLockNode);
                return true;
            }else{
                unlock(lockName);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     * 存储本次线程中添加的锁
     * @param lockPath
     */
    private void addLock(String lockPath) {
        List<String> list = nodePathList.get();
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(lockPath);
        nodePathList.set(list);
    }

    /**
     * 删除锁
     */
    public void unlock(String lockName) {
        try {
            String lockPathPrefix = root + "/" + lockName;
            String lockPath = "";
            List<String> list = nodePathList.get();
            if (list != null && list.size() > 0) {
                Iterator<String> iterator = list.iterator();
                while (iterator.hasNext()) {
                    String lockWholePath = iterator.next();
                    if (lockWholePath.contains(lockPathPrefix)) {
                        lockPath = lockWholePath;
                        iterator.remove();
                        break;
                    }
                }
                if (StringUtils.isNotBlank(lockPath)) {
                    Stat stat = zk.exists(lockPath, true);
                    if (stat != null) {
                        zk.delete(lockPath, -1);
                        logger.info("锁释放成功，锁路径为：{}", lockPath);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
