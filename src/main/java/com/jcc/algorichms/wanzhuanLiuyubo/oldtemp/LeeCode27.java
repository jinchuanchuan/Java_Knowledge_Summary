package com.jcc.algorichms.wanzhuanLiuyubo.oldtemp;

/**
 * @program: javaknowledge->LeeCode27
 * @description: 27
 * @author: jinchuanchuan1@le.com
 * @create: 2020-11-07 16:12
 **/
public class LeeCode27 {
    public int removeElement(int[] nums, int val) {
        // 此题同283思路
        // 在nums中，[k, nums.length)都是等于val的，返回nums.length - k
        int k = nums.length - 1;
        // 从后向前遍历，保证[k, nums.length - 1]都是等于val的值，
        // [0, k-1]都是非val值
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] == val) {
                if(k != i) {
                    int temp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = temp;
                    k--;
                } else {
                    k--;
                }
            }
        }
        return k + 1;
    }
}
