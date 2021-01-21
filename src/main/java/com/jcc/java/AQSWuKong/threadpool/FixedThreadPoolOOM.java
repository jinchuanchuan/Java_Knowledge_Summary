package com.jcc.java.AQSWuKong.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: javaknowledge->FixedThreadPoolOOM
 * @description: 演示内存出错的情况
 * @author: jinchuanchuan1@le.com
 * @create: 2020-12-29 18:21
 **/
public class FixedThreadPoolOOM {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < Integer.MAX_VALUE;  i++) {
            executorService.execute(new SubTask());
        }
    }
}
class SubTask implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
