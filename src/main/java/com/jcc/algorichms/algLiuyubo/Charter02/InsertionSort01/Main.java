package com.jcc.algorichms.algLiuyubo.Charter02.InsertionSort01;

import java.util.Arrays;

/**
 * @program: javaknowledge->Main
 * @description: main方法
 * @author: jinchuanchuan1@le.com
 * @create: 2020-12-27 16:09
 **/
public class Main {
    // 比较SelectionSort和InsertionSort两种排序算法的性能效率
    // 此时，插入排序比选择排序性能略低
    public static void main(String[] args) {
        int N = 20000;
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        SortTestHelper.testSort("com.jcc.algorichms.algLiuyubo.Charter02.InsertionSort01.SelectionSort", arr1);
        SortTestHelper.testSort("com.jcc.algorichms.algLiuyubo.Charter02.InsertionSort01.InsertionSort", arr2);

    }
}
