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
            // 通过赋值来替换掉swap，让性能更优。
            Comparable t = arr[i];
            int j = i; // j 保存元素t应该插入的位置。
            for (; j > 0 && arr[j-1].compareTo(t) > 0; j--) {
                arr[j] = arr[j-1]; // 把前一个位置的元素向后挪一下
            }
            arr[j] = t;
        }
    }

    // 2022/04/08
    // 练习
    public static void sort01(int[] arr) {
        // i为1的原因：从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {
            // 从已经排序的序列最右边的开始比较，找到比其小的数进行交换，直到遇到比它大的终止。
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swapInteger(arr, j,j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void sort02(int[] arr) {
        // i为0的原因：从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {
            // 通过赋值来替换掉swap，让性能更优
            int t = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1] > t; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }
    private static void swapInteger(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
