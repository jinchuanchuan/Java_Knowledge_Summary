package com.jcc.pattern.templateMethodPattern;

/**
 * @program: javaknowledge->TemplateMethodPattern
 * @description: 模版方法设计模式
 * @author: jinchuanchuan1@le.com
 * @create: 2020-03-13 16:34
 **/
public class TemplateMethodPattern {
    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.templateMethod();
    }
}

/**
 * 抽象类
 */
abstract class AbstractClass {
    /**
     * 模版方法
     */
    public void templateMethod() {
        specificMethod();
        abstractClass1();
        abstractClass2();
    }

    /**
     * 具体方法
     */
    public void specificMethod() {
        System.out.println("抽象类中的具体方法被调用...");
    }

    /**
     * 抽象方法1
     */
    abstract void abstractClass1();

    /**
     * 抽象方法2
     */
    abstract void abstractClass2();
}

/**
 * 具体子类
 */
class ConcreteClass extends AbstractClass {

    @Override
    void abstractClass1() {
        System.out.println("抽象方法1的实现被调用...");
    }

    @Override
    void abstractClass2() {
        System.out.println("抽象方法2的实现被调用...");
    }
}
