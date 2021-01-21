package com.jcc.algorichms.algLiuyubo.Charter03.MergeSortAdance;

import java.util.Arrays;

/**
 * @program: javaknowledge->MergeSort2
 * @description: 优化归并算法
 * @author: jinchuanchuan1@le.com
 * @create: 2020-12-29 10:04
 **/
public class MergeSort2 {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n-1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        // 优化2：对小规模数组，直接使用插入排序。
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }
        int mid = l + (r-l)/2;
        sort(arr, l, mid);
        sort(arr, mid+1, r);
        // 优化1: 对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if (arr[mid].compareTo(arr[mid+1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j-l];
                j++;
            } else if(j > r) {
                arr[k] = aux[i-l];
                i++;
            } else if (aux[i-l].compareTo(aux[j-l]) < 0) {
                arr[k] = aux[i-l];
                i++;
            } else {
                arr[k] = aux[j-l];
                j++;
            }
        }
    }
}
