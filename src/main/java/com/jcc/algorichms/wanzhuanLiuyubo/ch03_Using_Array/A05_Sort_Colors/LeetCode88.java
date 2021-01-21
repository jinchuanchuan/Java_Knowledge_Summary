package com.jcc.algorichms.wanzhuanLiuyubo.ch03_Using_Array.A05_Sort_Colors;

import java.util.Arrays;

/**
 * @program: javaknowledge->LeetCode88
 * @description: 88 归并的merg过程
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-14 15:03
 *
 * 这个的merge操作的mid值一定选
 **/
public class LeetCode88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        for (int i = 0; i < nums.length; i++) {
            if (nums1[i] != 0) {
                nums[i] = nums1[i];
            }
        }
        for (int i = m; i < nums.length; i++) {
            if (nums2[i-m] != 0) {
                nums[i] = nums2[i-m];
            }
        }
        System.out.println("nums :" + Arrays.toString(nums));
        int l = 0;
        int r = nums.length -1;
        int mid = m - 1;
        int i = l;
        int j = mid + 1;
        System.out.println("i:" + i + ", j:" + j + ", mid:" + mid);
        for (int k = l; k <= r; k++) {
            System.out.println("k:" + k);
            if (i > mid) {
                nums1[k] = nums[j - l];
                j++;
            } else if(j > r) {
                nums1[k] = nums[i - l];
                i++;
            } else if (nums[i-l] < nums[j-l]) {
                nums1[k] = nums[i-l];
                i++;
            } else {
                nums1[k] = nums[j-l];
                j++;
            }
        }

        System.out.println("nums1:" + Arrays.toString(nums1));
    }

    public static void main(String[] args) {

        int[] nums1 = {4,0,0,0,0,0};
        int m = 1;
        int[] nums2 = {1,2,3,5,6};
        int n = 5;
        merge(nums1,m,nums2,n);
    }
}
