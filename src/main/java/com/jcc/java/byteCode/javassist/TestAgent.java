package com.jcc.java.byteCode.javassist;

import java.lang.instrument.Instrumentation;

/**
 * @program: javaknowledge->TestAgent
 * @description: TestAgent
 * @author: jinchuanchuan1@le.com
 * @create: 2020-03-10 11:11
 **/
public class TestAgent {
    public static void agentmain(String args, Instrumentation inst) {
        //指定我们自己定义的Transformer，在其中利用Javassist做字节码替换
        inst.addTransformer(new TestTransformer(), true);
        try {
            //重定义类并载入新的字节码
            inst.retransformClasses(Base.class);
            System.out.println("Agent Load Done.");
        } catch (Exception e) {
            System.out.println("agent load failed!");
        }
    }
}
