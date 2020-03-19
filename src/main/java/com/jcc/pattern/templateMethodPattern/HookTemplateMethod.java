package com.jcc.pattern.templateMethodPattern;

/**
 * @program: javaknowledge->HookTemplateMethod
 * @description: 测试模版方法模式中的hook问题
 * @author: jinchuanchuan1@le.com
 * @create: 2020-03-13 18:59
 **/
public class HookTemplateMethod {
    public static void main(String[] args) {
        HookAbstractClass hookAbstractClass = new HookConcreteClass();
        hookAbstractClass.hookTemlateMethod();
    }
}

abstract class HookAbstractClass {
    public void hookTemlateMethod() {
        abstractClass1();

        if (getResult()) {
            specificMethod();
        }

        abstractClass2();
    }

    public void specificMethod() {
        System.out.println("调用特殊方法");
    }

    public boolean getResult(){
        return true;
    }

    abstract void abstractClass1();

    abstract void abstractClass2();
}

class HookConcreteClass extends HookAbstractClass{

    @Override
    public boolean getResult() {
        return false;
    }

    @Override
    void abstractClass1() {
        System.out.println("调用实现方法1");
    }

    @Override
    void abstractClass2() {
        System.out.println("调用实现方法2");
    }
}