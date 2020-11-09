package com.jcc.algorichms.wanzhuansuanfayushujujiegouLiubobob.chapter3;

/**
 * @program: javaknowledge->LeeCode167
 * @description: 167
 * @author: jinchuanchuan1@le.com
 * @create: 2020-11-07 18:10
 **/
public class LeeCode167 {
    // 双索引技术：指针对撞

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length -1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i, j};
            } else if (numbers[i] + numbers[j] > target){
                j--;
            } else {
                i--;
            }
        }
        return null;
    }
}
