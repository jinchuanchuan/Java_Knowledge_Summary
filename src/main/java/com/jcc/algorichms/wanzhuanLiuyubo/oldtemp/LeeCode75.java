package com.jcc.algorichms.wanzhuanLiuyubo.oldtemp;

/**
 * @program: javaknowledge->LeeCode75
 * @description: 75
 * @author: jinchuanchuan1@le.com
 * @create: 2020-11-07 17:28
 **/
public class LeeCode75 {
    // 任意一种排序算法
    //

    /**
     * 计数排序：分别统计0，1，2的元素个数
     * @param nums
     */
    public void sortColors1(int[] nums) {
        // 用于存放0、1、2的频率
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            assert (nums[i] >=0 && nums[i] <= 2);
            count[nums[i]] ++ ;
        }
        int index = 0;
        for (int i = 0; i <= count[0]; i ++ ) {
            nums[index++] = 0;
        }
        for (int i = 0; i <= count[1]; i ++ ) {
            nums[index++] = 1;
        }
        for (int i = 0; i <= count[2]; i ++ ) {
            nums[index++] = 2;
        }
    }
    // 三路快排

    public void sortColors(int[] nums) {
        int zero = -1;
        int two = nums.length;

        for (int i = 0; i < two;) {
            if (nums[i] == 1) {
                i++;
            } else if(nums[i] == 2) {
                two--;
                // swap
                int temp = nums[i];
                nums[i] = nums[two];
                nums[two] = temp;
            } else {
                assert (nums[i] == 0);
                zero++;
                // swap
                int temp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = temp;
                i++;
            }
        }
    }
}

