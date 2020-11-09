package com.jcc.algorichms.wanzhuansuanfayushujujiegouLiubobob.chapter3;

import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: javaknowledge->LeeCode283
 * @description: 283
 * @author: jinchuanchuan1@le.com
 * @create: 2020-11-07 15:43
 **/
public class LeeCode283 {
    // 思路一
    public void moveZeroes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                list.add(nums[i]);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        for (int i = list.size(); i < nums.length; i++){
            nums[i] = 0;
        }
    }
    // 思路二
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public void moveZeroes2(int[] nums) {
        int k = 0; // nums中，[0,k)的元素全是非0
        // 遍历到第i个元素后，保证[0,i]中所有的非0元素，都按照顺序排列在[0...k)中
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }
        // 将nums剩余位置放置为0
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    // 思路三
    public void moveZeroes3(int[] nums) {
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        int k = 0; // nums中，[0,k)的元素全是非0
        // 遍历到第i个元素后，保证[0,i]中所有的非0元素，都按照顺序排列在[0...k)中
        // 同时[k...i]为0
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (k != i) {
                    int temp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = temp;
                    k++;
                } else {
                    k++;
                }

            }
        }

    }
}
