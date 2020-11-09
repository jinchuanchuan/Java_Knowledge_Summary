package com.jcc.java.concurrent.wukong.chapter03;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: javaknowledge->ScheduledThreadPool
 * @description: scheduledThreadPool
 * @author: jinchuanchuan1@le.com
 * @create: 2020-11-08 16:03
 **/
public class ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
//        scheduledExecutorService.schedule(new FixedThreadPoolTest.Task(), 5, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new FixedThreadPoolTest.Task(), 1,3,TimeUnit.SECONDS);
    }
}
