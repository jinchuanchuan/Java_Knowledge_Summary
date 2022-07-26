package com.jcc.algorichms.wanzhuanLiuyubo.ch03_Using_Array.A04_Move_Zeroes_II;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: javaknowledge->Solution
 * @description: 283
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-13 18:46
 **/
public class Solution2 {
    // 时间复杂度：O（n）
    // 空间复杂度：O（1)
    public void moveZeroes(int[] nums) {
        int k = 0; // nums中，[0...K)的元素均为非0元素
        // 遍历到第i个元素后，保证[0...i]中所有非0元素，都按照顺序排列在[0...k)中
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        // 将nums剩余的位置放置为0
        if(k < nums.length) {
            for (int i = k; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }

    public static void main(String args[]){

        int[] arr = {0, 1, 0, 3, 12};

        (new Solution2()).moveZeroes(arr);

        for(int i = 0 ; i < arr.length ; i ++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
