package com.jcc.algorichms.algLiuyubo.Charter03.MergeSort;

/**
 * @program: javaknowledge->InsertionSort
 * @description: 插入排序
 * @author: jinchuanchuan1@le.com
 * @create: 2020-12-28 21:28
 **/
public class InsertionSort {

    public static void sort(Comparable[] arr) {
//        int n = arr.length;
//        for (int i = 1; i < n; i++) {
////            int minIndex = i;
////            for (int j = i; j > 0; j--) {
////                if (arr[j].compareTo(arr[j-1]) < 0) {
////                    minIndex = j;
////                }
////            }
////            swap(arr, i, minIndex);
//            int minIndex = i;
//            int j = i;
//            for (; j > 0; j--) {
//                if (arr[j].compareTo(arr[j-1]) < 0) {
//                    arr[j] = arr[j-1];
//                }
//            }
//            arr[j] = arr[minIndex];
//        }
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            Comparable e = arr[i];
            int j = i;
            for( ; j > 0 && arr[j-1].compareTo(e) > 0 ; j--)
                arr[j] = arr[j-1];
            arr[j] = e;

        }
    }
    private static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
