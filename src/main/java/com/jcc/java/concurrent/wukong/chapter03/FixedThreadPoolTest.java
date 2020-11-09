package com.jcc.java.concurrent.wukong.chapter03;

import java.util.RandomAccess;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: javaknowledge->FixedThreadPoolTest
 * @description: fixedThereadPool demo
 * @author: jinchuanchuan1@le.com
 * @create: 2020-11-08 15:32
 **/
public class FixedThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Task());
        }
    }
    static class Task implements Runnable {

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
}
