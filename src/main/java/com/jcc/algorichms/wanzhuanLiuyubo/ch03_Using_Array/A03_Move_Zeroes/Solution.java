package com.jcc.algorichms.wanzhuanLiuyubo.ch03_Using_Array.A03_Move_Zeroes;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: javaknowledge->Solution
 * @description: 283
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-13 18:46
 **/
public class Solution {
    // 时间复杂度：O（n）
    // 空间复杂度：O（n），因为利用了额外的辅助空间
    public void moveZeroes(int[] nums) {
        List<Integer> nonZeroElements = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nonZeroElements.add(nums[i]);
            }
        }
        for (int i = 0; i < nonZeroElements.size(); i++) {
            nums[i] =  nonZeroElements.get(i);
        }
        for (int i = nonZeroElements.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String args[]){

        int[] arr = {0, 1, 0, 3, 12};

        (new Solution()).moveZeroes(arr);

        for(int i = 0 ; i < arr.length ; i ++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
