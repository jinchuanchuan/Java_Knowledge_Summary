package com.jcc.algorichms.algLiuyubo.Charter03.MergeSortAdance;

/**
 * @program: javaknowledge->InsertionSort
 * @description: 插入排序
 * @author: jinchuanchuan1@le.com
 * @create: 2020-12-28 21:28
 **/
public class InsertionSort {

    // 我们的算法类不允许产生任何实例
    private InsertionSort(){}

    // 对整个arr数组使用InsertionSort排序
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            Comparable e = arr[i];
            int j = i;
            for( ; j > 0 && arr[j-1].compareTo(e) > 0 ; j--)
                arr[j] = arr[j-1];
            arr[j] = e;

        }
    }
    // 对arr[l...r]的区间使用InsertionSort排序
    public static void sort(Comparable[] arr, int l, int r) {
        int n = arr.length;
        for (int i = l+1; i <= r; i++) {
            Comparable e  = arr[i];
            int j = i;
            for ( ; j > l && arr[j-1].compareTo(e) > 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }
    private static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
