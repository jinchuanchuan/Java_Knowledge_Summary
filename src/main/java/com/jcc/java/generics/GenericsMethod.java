package com.jcc.java.generics;

import com.jcc.java.lambda.Test01;

import java.util.*;

/**
 * @program: javaknowledge->GenericsMethod
 * @description: 泛型方法
 * @author: jinchuanchuan1@le.com
 * @create: 2020-08-18 18:01
 **/
public class GenericsMethod {

    //递归类型限制
    public static void main(String[] args) {
//        String[] ss = new String[] { "Orange", "Apple", "Pear" };
//        Arrays.sort(ss);
//        System.out.println(Arrays.toString(ss));

        test01();
    }

    /**
     *
     * @param s1
     * @param s2
     * @param <E>
     * @return
     */
    //类型参数列表为＜ E ＞
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public void checkChangeUp() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
//        integerArrayList.add(new Integer(123));
//        ArrayList<Number> numberArrayList = integerArrayList;
//        numberArrayList.add(new Float(12.3));
//        Integer n = integerArrayList.get(1);
    }

    public void test() {
        // 编译器警告:
        List list = new ArrayList();
        list.add("Hello");
        list.add("World");
        String first = (String) list.get(0);
        String second = (String) list.get(1);

        // 无编译器警告:
        List<String> list01 = new ArrayList<String>();
        list01.add("Hello");
        list01.add("World");
        // 无强制转型:
        String first01 = list01.get(0);
        String second01 = list01.get(1);

        List<Number> list03 = new ArrayList<Number>();
        list03.add(new Integer(123));
        list03.add(new Double(12.34));
        Number first03 = list03.get(0);
        Number second03 = list03.get(1);
    }

    public static void test01() {
        Person[] ps = new Person[] {
                new Person("Bob", 61),
                new Person("Alice", 88),
                new Person("Lily", 75),
        };
        Arrays.sort(ps);
        System.out.println(Arrays.toString(ps));
    }


//    static class Person {
//        String name;
//        int score;
//        Person(String name, int score) {
//            this.name = name;
//            this.score = score;
//        }
//        @Override
//        public String toString() {
//            return this.name + "," + this.score;
//        }
//    }

    static class Person implements Comparable<Person> {
        String name;
        int score;
        Person(String name, int score) {
            this.name = name;
            this.score = score;
        }
        @Override
        public int compareTo(Person other) {
//            return this.name.compareTo(other.name);
            return this.score - other.score;
        }
        @Override
        public String toString() {
            return this.name + "," + this.score;
        }
    }
}
