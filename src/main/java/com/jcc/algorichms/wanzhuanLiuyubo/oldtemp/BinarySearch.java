package com.jcc.algorichms.wanzhuanLiuyubo.oldtemp;

/**
 * @program: javaknowledge->BinarySearch
 * @description: 二分查找法
 * @author: jinchuanchuan1@le.com
 * @create: 2020-12-28 17:50
 **/
public class BinarySearch {
    public static int  binary(int[] arr, int target) {
        int l = 0;
        int r = arr.length -1;
        while (l <= r) {
            int middle = l + (r - l)/2;
            if (target == arr[middle]) {
                return middle;
            } else if (target > arr[middle]) {
                l = middle + 1;
            } else {
                r = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("i = " + binary(arr, 9));
    }
}
