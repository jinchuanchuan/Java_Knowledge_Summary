package com.jcc.algorichms.algLiuyubo.Charter02.SelectionSort04;

import java.lang.reflect.Method;

/**
 * @program: javaknowledge->SortTestHelper
 * @description: sort helper
 * @author: jinchuanchuan1@le.com
 * @create: 2020-12-27 15:17
 **/
public class SortTestHelper {
    private SortTestHelper() { }

    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Integer((int)(Math.random() * (rangeR - rangeL + 1) + rangeL));
        }
        return arr;
    }
    public static void printArray(Object arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    // 判断数组是否有序
    public static Boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(arr[i=1]) < 0) {
                return true;
            }
        }
        return false;
    }
    public static void testSort(String className, Comparable[] arr) {

        try {
            Class<?> sortClass = Class.forName(className);

            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null,params);
            long endTime = System.currentTimeMillis();

            assert isSorted( arr );

            printArray(arr);

            System.out.println( "消耗时间：" + sortClass.getSimpleName()+ " : " + (endTime-startTime) + "ms" );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
