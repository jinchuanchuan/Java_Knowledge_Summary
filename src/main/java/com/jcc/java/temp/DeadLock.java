package com.jcc.java.temp;


/**
 * @program: javaknowledge->DeadLock
 * @description: 死锁
 * @author: jinchuanchuan1@le.com
 * @create: 2021-03-03 10:36
 **/
public class DeadLock {
    private static Object object1 = new Object();
    private static Object object2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (object1) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 等待object2锁
                System.out.println("等待object2锁");
                synchronized (object2) {
                    System.out.println("线程1完成:" + Thread.currentThread().getName());
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (object2) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 等待object1锁
                System.out.println("等待object1锁");
                synchronized (object1) {
                    System.out.println("线程2完成:" + Thread.currentThread().getName());
                }
            }
        }).start();
    }
}
