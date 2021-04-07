package com.jcc.algorichms.leetcode_swordfingeroffer;

import java.util.Arrays;

/**
 * @program: javaknowledge->offer17
 * @description:
 * @author: jinchuanchuan1@le.com
 * @create: 2021-02-19 17:45
 **/
public class offer17 {
    public static void main(String[] args) {
        printNumbers(2);
    }
    public static int[] printNumbers(int n) {
        if( n == 0) {
            return null;
        }
        int temp = 0;
        for(int i = 1; i <= n; i++) {
            System.out.println("limian : " + temp);
            temp = temp * 10 + 9;
        }
        System.out.println("temp : " + temp);
        int[] nums =  new int[temp];
        for(int j = 1; j <= temp; j++) {
            nums[j-1] = j;
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }
}
