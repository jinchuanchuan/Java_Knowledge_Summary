package com.jcc.java.byteCode.javassist;

import javassist.*;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @program: javaknowledge->TestTransformer
 * @description: TestTransformer
 * @author: jinchuanchuan1@le.com
 * @create: 2020-03-10 10:59
 **/
public class TestTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        System.out.println("Transforming:" + className);
        try {
            ClassPool cp = ClassPool.getDefault();
            CtClass cc = cp.get("com.jcc.java.byteCode.javassist.Base");
            CtMethod cm = cc.getDeclaredMethod("process");
            cm.insertBefore("{ System.out.println(\"start\"); }");
            cm.insertAfter("{ System.out.println(\"end\"); }");
            return cc.toBytecode();
        } catch (Exception e) {

        }
        return null;
    }
}
