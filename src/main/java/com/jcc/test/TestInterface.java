package com.jcc.test;

public interface TestInterface {
    String name = "2232";

    default void method01() {
        System.out.println("我是一个默认方法。");
    }

    void abstractMethod01();
}
