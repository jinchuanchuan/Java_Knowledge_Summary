package com.jcc.algorichms.wanzhuansuanfayushujujiegouLiubobob.chapter3;

/**
 * @program: javaknowledge->LeeCode26
 * @description: 26
 * @author: jinchuanchuan1@le.com
 * @create: 2020-11-07 16:54
 **/
public class LeeCode26 {
    public int removeDuplicates(int[] nums) {
        // 时间复杂度O(n)
        // 空间复杂度O(1)
        // 思路：双指针
        // 在nums中，[0,k]中都是存放不重复数字，
        // 循环nums，当k != i切nums[k] != nums[i]时，k++后，将nums[k]和nums[i]互换，返回k + 1
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k != i && nums[k] != nums[i]){
                k++;
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
            }
        }
        return k + 1;
    }
}
