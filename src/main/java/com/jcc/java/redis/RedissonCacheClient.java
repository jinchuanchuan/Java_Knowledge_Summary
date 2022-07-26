package com.jcc.java.redis;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 基于Redisson实现Redis客户端
 * github：https://github.com/redisson/redisson
 *
 * @author liudewei
 * @date 2019/12/23
 */
@Component
public class RedissonCacheClient {

    @Autowired
    RedissonClient redissonClient;

    /**
     * 使用无参的lock()锁方法，调用后会对lockName自动添加上分布式锁，同时watchDog自动延长锁的过期时间
     * 释放锁方式：
     * 1、主动调用unlock()方法释放锁
     * 2、当前应用所在机器宕机过期后自动释放锁，其他线程自动尝试获得锁
     *
     * @param lockName
     */
    public void lock(String lockName) {
        redissonClient.getLock(lockName).lock();

    }

    /**
     * 尝试获得锁，无法获得锁直接返回，不阻塞
     *
     * @param lockName
     */
    public boolean tryLock(String lockName) {
        return redissonClient.getLock(lockName).tryLock();
    }

    /**
     * 对lockName释放分布式锁
     *
     * @param lockName
     */
    public void unlock(String lockName) {
        redissonClient.getLock(lockName).unlock();
    }

    // 公平锁
    RLock fairLock = redissonClient.getFairLock("anyLock");
}
