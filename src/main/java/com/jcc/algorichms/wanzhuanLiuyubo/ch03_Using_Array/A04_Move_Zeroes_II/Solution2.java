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
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
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
