package com.jcc.algorichms.wanzhuanLiuyubo.ch03_Using_Array.A01_Binary_Search;

/**
 * @program: javaknowledge->Util
 * @description: util
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-13 18:21
 **/
public class Util {
    private Util(){}

    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

        assert n > 0 && rangeL <= rangeR;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = (int)(Math.random() * (rangeR - rangeL + 1)) + rangeL;
        return arr;
    }

    public static Integer[] generateOrderedArray(int n) {

        assert n > 0;

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++)
            arr[i] = i;
        return arr;
    }
}
