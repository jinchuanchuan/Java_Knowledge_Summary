package com.jcc.algorichms.algorithmsAndDataStructuresLiuBobo;

import java.util.Random;

/**
 * @program: javaknowledge->SortUtils
 * @description: 工具类
 * @author: jinchuanchuan1@le.com
 * @create: 2020-08-12 15:42
 **/
public class SortUtils {

    public static int[] getRandomIntArray(int n) {
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            int random = (int) (Math.random() * 10000 + 1);
            arr[i] = random;
        }
        return arr;
    }
}
