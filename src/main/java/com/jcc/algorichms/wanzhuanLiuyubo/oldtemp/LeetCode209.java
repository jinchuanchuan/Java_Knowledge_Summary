package com.jcc.algorichms.wanzhuanLiuyubo.oldtemp;

/**
 * @program: javaknowledge->LeetCode209
 * @description: 滑动窗口
 * @author: jinchuanchuan1@le.com
 * @create: 2020-11-07 18:36
 **/
public class LeetCode209 {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;
        int r = -1;
        int res = nums.length;
        int sum = 0 ;
        while (l < nums.length) {
            if (r + 1 < nums.length &&sum < s) {
                r++;
                sum = sum + nums[r];
            } else {
                sum = sum - nums[l];
                l++;
            }
            if (sum >= s) {
                res = Math.min(res, r-l+1);
            }
        }
        if (res == nums.length) {
            return 0;
        }
        return res;
    }
}
