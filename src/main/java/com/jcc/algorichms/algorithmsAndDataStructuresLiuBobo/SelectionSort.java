package com.jcc.algorichms.algorithmsAndDataStructuresLiuBobo;

import java.util.Arrays;

/**
 * @program: javaknowledge->SelectionSort
 * @description: 选择排序
 * 平均时间复杂度O(n2),最好O(n2),最坏O(n2),时间复杂度O(1),不稳定
 * @author: jinchuanchuan1@le.com
 * @create: 2020-08-12 15:29
 **/
public class SelectionSort {
    //测试
    public static void main(String[] args) {
        int arr[] = SortUtils.getRandomIntArray(10);
        System.out.println(Arrays.toString(arr));
        System.out.println("--------------");
        System.out.println(Arrays.toString(selectionSort(arr)));
    }
    public static int[] selectionSort(int[] arr){
        //TODO 1、抽取 int length = arr.length;
        //其实循环 n-1 次就可以
        for (int i = 0; i < arr.length; i++) {
            //寻找[i, i.length)区间里的最小值
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //将找到的最小值与i位置的值进行交换
            if (arr[i] > arr[minIndex]) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }
}
