package com.jcc.test.threadLocalTest;

public class Class02 {
    void classMethod() {
        System.out.println("我是class 02 的方法！");
        System.out.println("我是class 02,我要去调用class03 的方法！");
        Class03 class03 = new Class03();
        class03.classMethod();
    }
}
