package com.jcc.algorichms.sort;


import java.util.Arrays;


public class QuickSort {

    private static int partition(int[] nums, int l, int r) {
        int v = nums[l];
        int j = l;
        for(int i = l+1; i <= r; i++) {
            if(nums[i] < v) {
                swap(nums, j+1, i);
                j++;
            }
        }
        swap(nums, l, j);
        return j;
    }
    private static void sort(int[] nums, int l, int r) {
        if(l >= r) return;

        int p = partition(nums, l, r);
        sort(nums, l, p-1);
        sort(nums, p+1, r);
    }



    public static void quickSort(int[] nums) {
        sort(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,5,8,9,22,3,4,9};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
