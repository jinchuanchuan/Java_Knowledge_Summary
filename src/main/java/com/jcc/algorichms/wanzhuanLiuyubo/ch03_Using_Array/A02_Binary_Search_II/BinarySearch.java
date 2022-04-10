package com.jcc.algorichms.wanzhuanLiuyubo.ch03_Using_Array.A02_Binary_Search_II;

/**
 * @program: javaknowledge->BinarySearch
 * @description: 二分查找
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-13 18:19
 **/
public class BinarySearch {

    public static int binarySearch(Comparable[] arr, int n, Comparable target) {
        int l = 0;
        int r = n;
        // 在[l,r) 的范围去寻找target
        while (l < r) { // 当 l = r 时，区间[l,r)依然是无效的。
//            int mid = (l+r)/2;
            int mid = l + (r-l)/2;
            if (arr[mid].compareTo(target) == 0) {
                return mid;
            }
            if (target.compareTo(arr[mid]) > 0) {
                l = mid + 1; // target在[mid + 1, r)区间，[l...mid]一定没有target
            } else { // target < arr[mid]
                r = mid; // target在[l...mid)中; [mid...r)一定没有target
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        int n = (int)Math.pow(10, 7);
        Integer data[] = Util.generateOrderedArray(n);

        long startTime = System.currentTimeMillis();
        for(int i = 0 ; i < n ; i ++)
            if(i != binarySearch(data, n, i))
                throw new IllegalStateException("find i failed!");
        long endTime = System.currentTimeMillis();

        System.out.println("Binary Search test complete.");
        System.out.println("Time cost: " + (endTime - startTime) + " ms");
    }
}
