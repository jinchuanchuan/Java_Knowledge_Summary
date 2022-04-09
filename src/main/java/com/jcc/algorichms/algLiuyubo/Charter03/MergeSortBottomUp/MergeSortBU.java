package com.jcc.algorichms.algLiuyubo.Charter03.MergeSortBottomUp;

import java.util.*;

public class MergeSortBU{

    public static void merge(Comparable[] arr, int l, int mid, int r) {
        //
        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分的起始索引位置
        int i = l;
        int j = mid+1;

        for (int k = l; k <= r; k++) {
            if (i > mid) { // 如果左半部分已经全部处理完
                arr[k] = aux[j-l];
                j++;
            } else if(j > r) { // 如果右半部分已经全部处理完
                arr[k] = aux[i-l];
                i++;
            } else if (aux[i-l].compareTo(aux[j-l]) < 0) { // 左半部分所指元素 <  右半部分所指元素
                arr[k] = aux[i-l];
                i++;
            } else {
                arr[k] = aux[j-l]; // 左半部分所指元素 >= 右半部分所指元素
                j++;
            }
        }
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int sz = 1; sz < n; sz += sz) { //每次1、2、4、8元素，以此类推
            for (int i = 0; i + sz < n; i += sz + sz) {
                // 对 arr[i + sz - 1] 和  arr[i+sz...i+2*sz-1]进行归并
                merge(arr, i, i + sz - 1,Math.min(i + sz + sz - 1, n-1));
            }
        }
    }

    // 测试 MergeSort BU


    public static void main(String[] args) {

        // Merge Sort BU 也是一个O(nlogn)复杂度的算法，虽然只使用两重for循环
        // 所以，Merge Sort BU也可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易根据循环层数来判断算法的复杂度，Merge Sort BU就是一个反例
        // 关于这部分陷阱，推荐看我的《玩转算法面试》课程，第二章：《面试中的复杂度分析》：）
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("bobo.algo.MergeSortBU", arr);

        return;
    }
}