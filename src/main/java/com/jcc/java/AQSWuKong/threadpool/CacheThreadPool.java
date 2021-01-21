package com.jcc.java.AQSWuKong.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: javaknowledge->CacheThreadPool
 * @description: cache threadpool
 * @author: jinchuanchuan1@le.com
 * @create: 2020-12-29 18:45
 **/
public class CacheThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Task());
        }

    }
}
