package com.jcc.algorichms.sort;

import java.util.Arrays;

public class MergeSort {
    static void mergeSort(int[] nums, int l, int mid, int r) {
        int[] aux = Arrays.copyOfRange(nums, l, r + 1);
        int i = l, j = mid+1;
        for(int k = l; k <= r; k++) {
            if(i > mid) {
                nums[k] = aux[j-l];
                j++;
            } else if (j > r) {
                nums[k] = aux[i-l];
                i++;
            } else if(aux[i-l] < aux[j-l]) {
                nums[k] = aux[i-l];
                i++;
            } else {
                nums[k] = aux[j-l];
                j++;
            }
        }
    }

    static void merge(int[] nums, int l, int r) {
        if(l >= r) {
            return;
        }
        int mid = (l+r)/2;
        merge(nums, l, mid);
        merge(nums, mid+1, r);
        mergeSort(nums, l, mid, r);
    }

    public static void mergeSort(int[] nums) {
        merge(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,5,8,9,22,3,4,9};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
