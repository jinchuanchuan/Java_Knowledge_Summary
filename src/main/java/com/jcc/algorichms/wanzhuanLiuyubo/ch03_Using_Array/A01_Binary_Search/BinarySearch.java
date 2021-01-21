package com.jcc.algorichms.wanzhuanLiuyubo.ch03_Using_Array.A01_Binary_Search;

/**
 * @program: javaknowledge->BinarySearch
 * @description: 二分查找
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-13 18:19
 **/
public class BinarySearch {

    public static int binarySearch(Comparable[] arr, int n, Comparable target) {
        int l = 0;
        int r = n - 1;
        // [l,r] 的闭区间去寻找target
        while (l <= r) { // l = r 的时候区间内也是有值的
            int mid = (l+r)/2;
            mid  = l + (r-l)/2;
            if (arr[mid].compareTo(target) == 0) {
                return mid;
            }
            if (arr[mid].compareTo(target) < 0) {
                l = mid + 1; // target在[mid + 1, l]区间，[l...mid]一定没有target
            } else { // target < arr[mid]
                r = mid -1; // target在[l...mid-1]中; [mid...r]一定没有target
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
