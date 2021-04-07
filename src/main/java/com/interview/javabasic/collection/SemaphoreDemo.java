package com.interview.javabasic.collection;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @program: javaknowledge->SemaphoreDemo
 * @description: Semaphore
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-26 18:20
 **/
public class SemaphoreDemo {
    public static void main(String[] args) {
        // 线程池
        ExecutorService executors =  Executors.newCachedThreadPool();
        // 只能5个线程同时访问
        final Semaphore semaphore = new Semaphore(5);
        // 模拟20个客户端访问
        for (int index = 0; index < 20; index++) {
            final int NO = index;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        // 获取许可
                        semaphore.acquire();
                        System.out.println("Accessing" + NO);
                        Thread.sleep((long) (Math.random()) * 10000);
                        // 访问完后，释放
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executors.execute(run);
        }
        executors.shutdown();
    }
}
