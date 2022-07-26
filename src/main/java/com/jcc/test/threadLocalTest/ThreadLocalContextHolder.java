package com.jcc.test.threadLocalTest;

import org.springframework.core.NamedThreadLocal;
import org.springframework.format.datetime.standard.DateTimeContext;

public class ThreadLocalContextHolder {
    public static final ThreadLocal<String> stringContextHolder = new NamedThreadLocal01<>("StringContextHolder");
}
