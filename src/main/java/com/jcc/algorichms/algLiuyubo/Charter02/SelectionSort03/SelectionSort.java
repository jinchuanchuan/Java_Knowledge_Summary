package com.jcc.algorichms.algLiuyubo.Charter02.SelectionSort03;

/**
 * @program: javaknowledge->SelectionSort
 * @description: 选择排序
 * @author: jinchuanchuan1@le.com
 * @create: 2020-12-27 14:16
 **/
public class SelectionSort {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        // 寻找[i,n)区间最小值的索引
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Swap(arr, i, minIndex);
        }

    }

    private static void Swap(Object[] arr, int i, int j) {
        Object temp =  arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SelectionSort.sort( arr );
        SortTestHelper.printArray(arr);

        return;
    }
}
