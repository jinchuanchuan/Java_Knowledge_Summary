package com.jcc.java.lambda;

import java.util.List;

/**
 * @program: javaknowledge->Test01
 * @description: Lambda示例
 * @author: jinchuanchuan1@le.com
 * @create: 2020-05-08 19:51
 **/
public class Test01 {
    public static void main(String[] args) {
        /*//布尔表达式
        (List<String> list) -> list.isEmpty();
        //创建对象
        () -> new Object();
        //消费对象
        (Object o) -> {
            System.out.println(o.getClass());
        }
        //从一个对象选择或抽取
        (String s) -> s.length();
        //组合两个值
        (int a, int b) -> a * b;
        //比较两个对象
        (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight())*/
        test001();
    }
    public static void test001() {
        Test01 test01 = new Test01();

        MathOperation addition = (int a, int b) -> a + b;

        MathOperation subtraction = (a, b) -> a - b;

        MathOperation multiplication = (int a, int b) -> { return a * b;};

        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + test01.operate(10, 5, addition));
        System.out.println("10 - 5 = " + test01.operate(10, 5, subtraction));
        System.out.println("10 * 5 = " + test01.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + test01.operate(10, 5, division));

        System.out.println(addition.operation(1, 3));

        GreetingService greetingService01 = name -> System.out.println("Hello " +  name);
        GreetingService greetingService02 = (String name) -> System.out.println("Hello " + name);
        greetingService01.sayHello("lily");
        greetingService02.sayHello("hanmeimei");

    }

    interface GreetingService {
        void sayHello(String name);
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
