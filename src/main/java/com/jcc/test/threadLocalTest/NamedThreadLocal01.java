package com.jcc.test.threadLocalTest;

import org.springframework.util.Assert;

public class NamedThreadLocal01<T> extends ThreadLocal<T>{
    private final String name;

    public NamedThreadLocal01(String name) {
        Assert.hasText(name, "Name must not be empty");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name;
    }
}
