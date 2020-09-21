package com.jcc.algorichms.algorithmsAndDataStructuresLiuBobo;

import java.util.Arrays;

import static com.jcc.algorichms.algorithmsAndDataStructuresLiuBobo.SortUtils.swap;


/**
 * @program: javaknowledge->QuickSort
 * @description: 快速排序
 * @author: jinchuanchuan1@le.com
 * @create: 2020-08-19 09:18
 **/
public class QuickSort {
    //在近乎有序的排序中，快速排序最差情况，退化为O(n2)
    //随机值：在[l,r]之间随机选个值，与arr[l]交换

    //测试
    public static void main(String[] args) {
        int arr[] = SortUtils.getRandomIntArray(10);
        System.out.println(Arrays.toString(arr));
        System.out.println("--------------");
        quickSort(arr);
//        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int arr[]) {
        quickSortIter(arr, 0, arr.length -1);
    }

    // 对arr[l...r]的区间进行快排
    private static void quickSortIter(int arr[], int l, int r) {
        if(l >= r) {
            return ;
        }
        int p = partition(arr, l, r);
        quickSortIter(arr, l, p - 1);
        quickSortIter(arr, p + 1, r);
        System.out.println(Arrays.toString(arr));

    }

    // 对arr[l...r]的区间进行快速排序
    // 返回p，使得arr[l... p-1] < arr[p]; arr[p + 1... r] > arr[p]
    private static int partition(int arr[], int l, int r) {

        int v = arr[l];
        //arr[l + 1 ... j] < v; arr[j + 1 ... i) > v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                // 交换
                int temp = arr[i];
                arr[i] = arr[j + 1];
                arr[j + 1] = temp;
                // j 向后移动
                j++;
            }
        }
        //将选定值交换到指定位置
        int temp = arr[l];
        arr[l] = arr[j];
        arr[j] = temp;
        System.out.println("j : " + j);
//        System.out.println(Arrays.toString(arr));
        return j;
    }

    /**
     * 两路快排
     */
    private static int partition02(int arr[], int l, int r) {

        return 0;
    }

    /**
     * 三路快排
     */
}
