package com.jcc.algorichms.wanzhuanLiuyubo.ch03_Using_Array.A04_Move_Zeroes_II;

/**
 * @program: javaknowledge->Solution
 * @description: 283
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-13 18:46
 **/
public class Solution4 {
    public void moveZeroes(int[] nums) {
        int k = 0; // nums中, [0...k)的元素均为非0元素

        // 遍历到第i个元素后,保证[0...i]中所有非0元素
        // 都按照顺序排列在[0...k)中
        // 同时, [k...i] 为 0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (k != i) { // 特殊情况处理，如果整个数组都是非零0元素，则禁止自己和自己swap
                    int temp =  nums[i];
                    nums[i] = nums[k];
                    nums[k++] = temp;
                } else { // i == k
                    k++;
                }
            }
        }
    }

    public static void main(String args[]){

        int[] arr = {0, 1, 0, 3, 12};

        (new Solution4()).moveZeroes(arr);

        for(int i = 0 ; i < arr.length ; i ++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
