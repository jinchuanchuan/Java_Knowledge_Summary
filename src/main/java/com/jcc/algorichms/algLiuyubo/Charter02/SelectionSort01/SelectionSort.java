package com.jcc.algorichms.algLiuyubo.Charter02.SelectionSort01;

/**
 * @program: javaknowledge->SelectionSort
 * @description: 选择排序
 * @author: jinchuanchuan1@le.com
 * @create: 2020-12-27 14:16
 **/
public class SelectionSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        // 寻找[i,n)区间最小值的索引
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            Swap(arr, i, minIndex);
        }

    }

    private static void Swap(int[] arr, int i, int j) {
        int temp =  arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        SelectionSort.sort(arr);
        for( int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
