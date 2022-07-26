package com.jcc.test.threadLocalTest;

import org.springframework.core.NamedThreadLocal;

import java.util.HashMap;
import java.util.Map;

public class Class01 {

    void classMethod() {

        ThreadLocalContextHolder.stringContextHolder.set("我是在class 01 中set的！");
        System.out.println("我是class 01 的方法！");
        System.out.println("我是class 01，我要调用class 02 的方法！");
        Class02 class02 = new Class02();
        class02.classMethod();
    }
}
