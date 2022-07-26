package com.jcc.algorichms.algLiuyubo.Charter03.QuickSort;

import java.util.*;

public class QuickSort {

    // 我们的算法类不允许产生任何实例
    private QuickSort(){}

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p =  partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r) {
        Comparable v = arr[l];
        // arr[l+1...j] < v; arr[j+1...i) > v
        int j = l; // j 设置的很巧妙，为l，在arr[l+1...j]是空的，在arr[j+1...i)，因为是开区间，所以也是空的
        // 循环从 l + 1，开始，l位置的值就是v
        for (int i = l + 1; i <= r; i++) {
            // 隐含考虑的情况，当arr[i]大于v的时候，不用考虑，i++就可以。

            // 需要考虑的是arr[i] < v 的时候。
            if (arr[i].compareTo(v) < 0) {
                // 比较清晰的写法是
                swap(arr, i, j + 1);
                j++;
//                j++;
//                swap(arr, i, j);
            }
        }
        swap(arr, j, l);
        return j;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    // 测试 QuickSort
    public static void main(String[] args) {

        // Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.jcc.algorichms.algLiuyubo.Charter03.QuickSort.QuickSort", arr);

        return;
    }
}
