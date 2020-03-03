package com.jcc.java.concurrent.threadlocal;

/**
 * @program: javaknowledge->ThreadLocalNPE
 * @description: threadLocalNPE
 * @author: jinchuanchuan1@le.com
 * @create: 2020-03-03 19:56
 **/
public class ThreadLocalNPE {
    ThreadLocal<Long> longThreadLocal = new ThreadLocal<>();

    public void set() {
        longThreadLocal.set(Thread.currentThread().getId());
    }

    public Long get() {
        return longThreadLocal.get();
    }

    public static void main(String[] args) {
        ThreadLocalNPE threadLocalNPE = new ThreadLocalNPE();
        //如果get方法返回值为基本类型，则会报空指针异常，如果是包装类型就不会出错
        System.out.println("out:" + threadLocalNPE.get());

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocalNPE.set();
                System.out.println("inner:" + threadLocalNPE.get());
            }
        }).start();
    }
}
