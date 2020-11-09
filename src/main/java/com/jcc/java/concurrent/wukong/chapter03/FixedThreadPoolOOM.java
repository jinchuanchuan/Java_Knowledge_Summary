package com.jcc.java.concurrent.wukong.chapter03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: javaknowledge->FixedThreadPoolOOM
 * @description: OOM
 * @author: jinchuanchuan1@le.com
 * @create: 2020-11-08 15:38
 **/
public class FixedThreadPoolOOM {
    private static ExecutorService executorService = Executors.newFixedThreadPool(1);
    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            executorService.execute(new Task());
        }
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1000000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
