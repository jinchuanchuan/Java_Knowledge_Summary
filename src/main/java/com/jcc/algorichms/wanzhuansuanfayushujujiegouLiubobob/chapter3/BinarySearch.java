package com.jcc.algorichms.wanzhuansuanfayushujujiegouLiubobob.chapter3;

/**
 * @program: javaknowledge->BinarySearch
 * @description: 二分查找
 * @author: jinchuanchuan1@le.com
 * @create: 2020-11-07 10:01
 **/
public class BinarySearch {
    public static Integer binarySearchMethod(int[] arr, int n, int target) {
        // 查找不变量
        int l = 0; int r = n -1; // 在[l ... r] 前闭后闭区间查找
        while (l <= r) { // 因为l到r是前后闭区间，在l==r的时候，区间内也有值
            int mid = (l + r)/2;
            if (arr[mid] == target) {
                return mid;
            }
            if(target > arr[mid]) {
                l = mid + 1; // target在[mid + 1 ... r]区间
            } else {
                r = mid - 1; // target在[l ... mid - 1]区间
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            arr[i] = i;
        }
        for(int i=0;i<arr.length;i++)
        {
//            System.out.print(arr[i]+", ");
        }
        System.out.println("------------------");
        Long startTime = System.currentTimeMillis();
        int mid =binarySearchMethod(arr, 1000000,10);
        Long fullTime = System.currentTimeMillis();
        System.out.println("startTime：" + startTime + "_endTime：" + fullTime +"_mid：" + mid);

    }
}
