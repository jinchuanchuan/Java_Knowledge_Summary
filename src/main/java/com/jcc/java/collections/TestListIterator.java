package com.jcc.java.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @program: javaknowledge->TestListIterator
 * @description: 测试集合容器的Iterator
 * @author: jinchuanchuan1@le.com
 * @create: 2019-12-24 10:16
 **/
public class TestListIterator {

    public static void test1() {
        List list =  new ArrayList();
        list.add("aaa");
        list.add("fff");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    public static void main(String[] args) {
        test1();
    }

}
