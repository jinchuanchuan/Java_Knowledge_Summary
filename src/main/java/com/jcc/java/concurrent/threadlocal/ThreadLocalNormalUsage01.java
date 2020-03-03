package com.jcc.java.concurrent.threadlocal;

/**
 * @program: javaknowledge->ThreadLocalNormalUsage01
 * @description: ThreadLocal测试
 * @author: jinchuanchuan1@le.com
 * @create: 2020-03-02 17:16
 **/
public class ThreadLocalNormalUsage01 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                stringThreadLocal.set("01");
                System.out.println("first string: " + stringThreadLocal.get());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                stringThreadLocal.set("02");
                System.out.println("second string: " + stringThreadLocal.get());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
//                stringThreadLocal.set("02");
                System.out.println("null string: " + stringThreadLocal.get());
            }
        }).start();
    }
    public static ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
}
