package com.jcc.algorichms.algLiuyubo.Charter02.exercise;

import com.jcc.algorichms.algLiuyubo.Charter02.InsertionSort01.SortTestHelper;

import java.util.Arrays;

/**
 * @ClassName: InsertionSort.java
 * @Author: jinchuanchuan@longfor.com
 * @Date: 2022/4/9 10:55 上午:00
 * @Description: TODO
 */
public class InsertionSort {
    private static void sort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j-1] ; j--) {
                swapInteger(arr, j , j - 1);
            }
        }
    }

    private static void sortYouHua(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Integer temp = arr[i];
            int j = i;
            for (; j > 0 && arr[j-1] > temp ; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }


    private static void swapInteger(Integer[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void printArray(Object arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int N = 20000;
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        sortYouHua(arr1);
        printArray(arr1);
    }
}
