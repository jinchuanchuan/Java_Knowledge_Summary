package com.jcc.test;

import com.mysql.cj.util.StringUtils;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TestUnit {

    public static void main(String[] args) {
        String str = "abc";
    }

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int l = 0;
        int r = nums.length - 1;
        int index = nums.length - 1;
        while (l <= r) {
            int leftNum = nums[l];
            int rightNum = nums[r];
            if (Math.pow(leftNum, 2) > Math.pow(rightNum, 2)) {
                result[index] = (int) Math.pow(leftNum, 2);
                l++;
                index--;
            } else {
                result[index] = (int) Math.pow(rightNum, 2);
                r--;
                index--;
            }
        }
        return result;
    }
}
