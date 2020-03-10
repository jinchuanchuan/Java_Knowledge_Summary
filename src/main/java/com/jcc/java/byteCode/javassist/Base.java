package com.jcc.java.byteCode.javassist;

import java.lang.management.ManagementFactory;

/**
 * @program: javaknowledge->Base
 * @description: javassist bytecode test
 * @author: jinchuanchuan1@le.com
 * @create: 2020-03-10 10:13
 **/
public class Base {
    public static void main(String[] args) {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String s = name.split("@")[0];
        //打印当前Pid
        System.out.println("pid:" + s);
        while (true) {
            try {
                Thread.sleep(5000L);
            } catch (Exception e) {
                break;
            }
            process();
        }
    }

    public static void process() {
        System.out.println("process");
    }
}
