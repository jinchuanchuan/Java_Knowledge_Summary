package com.jcc.algorichms.algLiuyubo.Charter03.MergeSortAdance;

import java.util.Arrays;

/**
 * @program: javaknowledge->MergeSort
 * @description: 归并排序
 * @author: jinchuanchuan1@le.com
 * @create: 2020-12-28 21:26
 **/
public class MergeSort {

    public static void sort(Comparable[] arr) {
        int l = 0;
        int r = arr.length - 1;
        sort(arr, l, r);
    }
    // 递归使用归并排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l)/2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    // 将arr[l...mid]和[mid+1...r]两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);
        // 初始化，i指向左半部分的起始位置l；j指向右半部分的起始位置mid+1；
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) { // 如果左半部分元素已经全部处理完毕
                arr[k] = arr[j-l];
                j++;
            } else if(j > r) { // 如果右半部分元素已经全部处理完毕
                arr[k] = arr[i-l];
                i++;
            } else if (arr[i-l].compareTo(arr[j-l]) < 0) { // 左半部分所指元素 < 右半部分所指元素
                arr[k] = arr[i-l];
                i++;
            } else {
                arr[k] = arr[j-l]; // 左半部分所指元素 > 右半部分所指元素
                j++;
            }
        }

    }
}
