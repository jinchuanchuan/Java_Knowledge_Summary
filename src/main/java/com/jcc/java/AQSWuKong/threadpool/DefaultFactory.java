package com.jcc.java.AQSWuKong.threadpool;

import java.util.concurrent.Executors;

/**
 * @program: javaknowledge->DefaultFactory
 * @description: default factory
 * @author: jinchuanchuan1@le.com
 * @create: 2020-12-29 17:57
 **/
public class DefaultFactory {
    public static void main(String[] args) {
        Thread thread = Executors.defaultThreadFactory().newThread(new Task());
        thread.start();
    }
}
//
//class Task implements Runnable {
//
//
//    @Override
//    public void run() {
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName());
//    }
//}