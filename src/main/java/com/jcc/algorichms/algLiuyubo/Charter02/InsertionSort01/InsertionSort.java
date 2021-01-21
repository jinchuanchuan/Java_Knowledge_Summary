package com.jcc.algorichms.algLiuyubo.Charter02.InsertionSort01;

/**
 * @program: javaknowledge->InsertionSort
 * @description: 插入排序
 * @author: jinchuanchuan1@le.com
 * @create: 2020-12-27 16:09
 **/
public class InsertionSort {

    private InsertionSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
//            书写一
//            for (int j = i; j > 0; j--) {
//                if (arr[j].compareTo(arr[j-1]) < 0) {
//                    swap(arr, j,j - 1);
//                } else {
//                    break;
//                }
//            }
//            书写二
//            for (int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j--) {
//                 swap(arr, j,j - 1);
//            }
            Comparable t = arr[i];
            int j = i;
            for (; j > 0 && arr[j-1].compareTo(t) > 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = t;
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
