package com.jcc.java.AQSWuKong.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: javaknowledge->FixedThreadPool
 * @description: 固定线程池
 * @author: jinchuanchuan1@le.com
 * @create: 2020-12-29 18:06
 **/
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 100; i ++) {
            executorService.execute(new Task());
        }
    }
}
class Task implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }

}
