package com.jcc.java.byteCode.javassist;

import javassist.*;


/**
 * @program: javaknowledge->JavassistTest
 * @description: test javassist
 * @author: jinchuanchuan1@le.com
 * @create: 2020-03-10 10:18
 **/
public class JavassistTest {
    public static void main(String[] args) throws Exception{
//        Base b = new Base();
//        ClassPool cp = ClassPool.getDefault();
//        CtClass cc = cp.get("com.jcc.java.byteCode.javassist.Base");
//        CtMethod cm = cc.getDeclaredMethod("process");
//        cm.insertBefore("{ System.out.println(\"start\"); }");
//        cm.insertAfter("{ System.out.println(\"end\"); }");
//        Class c = cc.toClass();
//        cc.writeFile("/Users/leeco/Documents/workspace_self");
//        Base base = (Base) c.newInstance();
//        base.process();
        String name =  "#篮球世界，doing";
        System.out.println(name.replace("#", ""));

    }
}
