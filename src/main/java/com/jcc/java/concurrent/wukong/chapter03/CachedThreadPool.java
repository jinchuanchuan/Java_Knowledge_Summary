package com.jcc.java.concurrent.wukong.chapter03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: javaknowledge->CachedThreadPool
 * @description: cachedThreadPool
 * @author: jinchuanchuan1@le.com
 * @create: 2020-11-08 15:58
 **/
public class CachedThreadPool {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;
    private static final int count = -1 << COUNT_BITS;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            executorService.execute(new FixedThreadPoolTest.Task());
        }
        System.out.println("COUNT_BITS=" + COUNT_BITS);
        System.out.println("CAPACITY=" + CAPACITY);
        System.out.println("count=" + count);
    }
}
