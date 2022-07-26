package com.jcc.test.threadLocalTest;

import com.jcc.test.ErrorContext;

public class TestThreadLocal {
    public static void main(String[] args) {
        Class01 class01 = new Class01();
        System.out.println("开始执行..........");
        class01.classMethod();
        System.out.println("结束执行..........");

        int i = 123445454 & (10-1);
        System.out.println("i = " + i);

        // 验证treadLocal是一个对象吗
        Runnable task1 = () -> {

            System.out.println("task1 name--------" + ThreadLocalContextHolder.stringContextHolder.getClass().getName());
            System.out.println("task1 class========" + ThreadLocalContextHolder.stringContextHolder.getClass());
        };

        Runnable task2 = () -> {
            System.out.println("task2 name---------" + ThreadLocalContextHolder.stringContextHolder.getClass().getName());
            System.out.println("task2 class========" + ThreadLocalContextHolder.stringContextHolder.getClass());
        };

        new Thread(task1).start();

        new Thread(task2).start();
    }
}
