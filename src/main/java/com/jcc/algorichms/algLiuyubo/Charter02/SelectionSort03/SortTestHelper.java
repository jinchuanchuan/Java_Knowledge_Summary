package com.jcc.algorichms.algLiuyubo.Charter02.SelectionSort03;

/**
 * @program: javaknowledge->SortTestHelper
 * @description: sort helper
 * @author: jinchuanchuan1@le.com
 * @create: 2020-12-27 15:17
 **/
public class SortTestHelper {
    private SortTestHelper() { }

    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Integer((int)(Math.random() * (rangeR - rangeL + 1) + rangeL));
        }
        return arr;
    }
    public static void printArray(Object arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}
