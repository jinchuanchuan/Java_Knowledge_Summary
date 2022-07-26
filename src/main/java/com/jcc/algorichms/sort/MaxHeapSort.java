package com.jcc.algorichms.sort;

import java.util.Arrays;

public class MaxHeapSort {
    public static void sort(int[] arr){


        int n = arr.length;
        MaxHeap maxHeap = new MaxHeap(n);
        for (int i = 0; i < n; i++) {
            maxHeap.insert(arr[i]);
        }
        for(int i = n-1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }

//        int n = arr.length;
//        MaxHeap maxHeap = new MaxHeap(n);
//        for( int i = 0 ; i < n ; i ++ )
//            maxHeap.insert(arr[i]);

        for( int i = n-1 ; i >= 0 ; i -- )
            arr[i] = maxHeap.extractMax();
    }
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,5,8,9,22,3,4,9};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
