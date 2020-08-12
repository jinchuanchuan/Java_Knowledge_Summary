package com.jcc.algorichms.algorithmsAndDataStructuresLiuBobo;

import java.util.Arrays;

/**
 * @program: javaknowledge->InsertionSort
 * @description: 插入排序
 * 平均时间复杂度O(n2),最好O(n),最坏O(n2),时间复杂度O(1),稳定
 * 总结：插入排序是一个数的比较，希尔排序是n个有序数的比较
 * @author: jinchuanchuan1@le.com
 * @create: 2020-08-12 16:11
 **/
public class InsertionSort {
    //测试
    public static void main(String[] args) {
        int arr[] = SortUtils.getRandomIntArray(10);
        System.out.println(Arrays.toString(arr));
        System.out.println("--------------");
        System.out.println(Arrays.toString(insertionSort(arr)));
    }

    public static int[] insertionSort(int arr[]) {

        int length = arr.length;
        // 原始版本
        // 默认第一是排好序的,所以从1开始
        // 寻找元素arr[i]合适的插入位置
//        for (int i = 1; i < length; i++) {
//            for (int j = i; j > 0; j--) {
//                if (arr[j] < arr[j-1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j - 1];
//                    arr[j - 1] = temp;
//                } else {
//                    break;
//                }
//            }
//        }
        // 第一版优化
//        for (int i = 1; i < length; i++) {
//            for (int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
//                int temp = arr[j];
//                arr[j] = arr[j - 1];
//                arr[j - 1] = temp;
//            }
//        }
        // 最终版优化：优化的点是---进行一次交换，因为每一次交互都会创建三个对象；
        // 通过建立临时值，变为只进行一次交换
        for (int i = 1; i < length; i++) {
            int tempInt = arr[i];
            int j; // j保存元素e应该插入的位置
            for (j = i; j > 0 && arr[j-1] > tempInt; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = tempInt;
        }
        return arr;
    }
}
