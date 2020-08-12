package com.jcc.java.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

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
        test03();
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

    public static void test02() {
        Apple a1 = new Apple("01", 1.1);
        Apple a2 = new Apple("01", 2.1);
        Apple a3 = new Apple("01", 3.1);
        Apple a4 = new Apple("01", 4.1);
        Apple a5 = new Apple("01", 5.1);
        Apple a6 = new Apple("01", 6.1);
        Apple a7 = new Apple("01", 7.1);
        Apple a8 = new Apple("01", 8.1);
        Apple a9 = new Apple("01", 9.1);
        Apple a10 = new Apple("01", 10.1);

        List<Apple> list = new ArrayList<Apple>();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);
        list.add(a6);
        list.add(a7);
        list.add(a8);
        list.add(a9);
        list.add(a10);
        System.out.println("before: " + Arrays.toString(list.toArray()));
        list = list.stream().filter(t -> t.getWeight() > 6).collect(toList());
        System.out.println("after: " + Arrays.toString(list.toArray()));
        //System.out.println("collect: " + Arrays.toString(collect.toArray()));
    }

    public static void test03() {
        Integer integer = 1070;
        String str =  "1070";
        System.out.println(integer.equals(str));
        System.out.println(integer.toString().equals(str));
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
