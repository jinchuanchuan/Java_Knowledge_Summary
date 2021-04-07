package com.jcc.algorichms.leetcode_swordfingeroffer;

import java.util.Arrays;

/**
 * @program: javaknowledge->offer21
 * @description:
 * @author: jinchuanchuan1@le.com
 * @create: 2021-02-19 16:36
 **/
public class offer21 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11};
        exchange2(nums);
    }
    public static int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int temp = 0;
        while(left < right) {
            while(left < right && (nums[left] & 1) == 1) {
                left++;
            }
            while(left < right && (nums[right] & 1) == 0) {
                right--;
            }
            System.out.println("left : " + left);
            System.out.println("right : " + right);
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }
    public static int[] exchange2(int[] nums) {
        int len=nums.length;
        if(len==1)
            return nums;
        int i=0;
        int j=0;
        int temp=0;
        for(i=0;i<len;i++){//i is on the right,j is on the left
            if((nums[i]%2!=0)){
                temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }

}
