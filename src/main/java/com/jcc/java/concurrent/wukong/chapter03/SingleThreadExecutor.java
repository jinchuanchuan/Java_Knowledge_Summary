package com.jcc.java.concurrent.wukong.chapter03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: javaknowledge->SingleThreadExecutor
 * @description: singleThreadExecutor
 * @author: jinchuanchuan1@le.com
 * @create: 2020-11-08 15:55
 **/
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new FixedThreadPoolTest.Task());
        }
    }
}
