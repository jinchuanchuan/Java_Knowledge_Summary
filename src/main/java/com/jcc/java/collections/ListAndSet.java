package com.jcc.java.collections;

import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @program: javaknowledge->ListAndSet
 * @description: demo
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-17 11:49
 **/
public class ListAndSet {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.add("111");
        linkedList.add("333");
        linkedList.add("222");
        linkedList.add("444");
        linkedList.add("555");
        linkedList.add("111");
        System.out.println(linkedList);

        TreeSet<Object> treeSet = new TreeSet<>();
        treeSet.add("111");
        treeSet.add("333");
        treeSet.add("222");
        treeSet.add("444");
        treeSet.add("555");
        treeSet.add("111");
        System.out.println(treeSet);
    }
}
