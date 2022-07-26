package com.jcc.test.threadLocalTest;

public class Class03 {
    void classMethod() {
        System.out.println("我是class 03 的方法！");
        String s = ThreadLocalContextHolder.stringContextHolder.get();
        String name = ThreadLocalContextHolder.stringContextHolder.getClass().getName();
        System.out.println("我打印threadLocal的字符串：" + s + ",   name" + name);

    }
}
