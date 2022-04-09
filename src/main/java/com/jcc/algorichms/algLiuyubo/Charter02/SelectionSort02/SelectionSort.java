package com.jcc.algorichms.algLiuyubo.Charter02.SelectionSort02;

import java.util.Arrays;

/**
 * @program: javaknowledge->SelectionSort
 * @description: 选择排序
 * @author: jinchuanchuan1@le.com
 * @create: 2020-12-27 14:16
 **/
public class SelectionSort {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        // 寻找[i,n)区间最小值的索引
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Swap(arr, i, minIndex);
        }

    }

    private static void Swap(Object[] arr, int i, int j) {
        Object temp =  arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // 测试Integer
        Integer[] a = {10,9,8,7,6,5,4,3,2,1};
        com.jcc.algorichms.algLiuyubo.Charter02.SelectionSort03.SelectionSort.sort(a);
        for( int i = 0 ; i < a.length ; i ++ ){
            System.out.print(a[i]);
            System.out.print(' ');
        }
        System.out.println();

        // 测试Double
        Double[] b = {4.4, 3.3, 2.2, 1.1};
        com.jcc.algorichms.algLiuyubo.Charter02.SelectionSort03.SelectionSort.sort(b);
        for( int i = 0 ; i < b.length ; i ++ ){
            System.out.print(b[i]);
            System.out.print(' ');
        }
        System.out.println();

        // 测试String
        String[] c = {"D", "C", "B", "A"};
        com.jcc.algorichms.algLiuyubo.Charter02.SelectionSort03.SelectionSort.sort(c);
        for( int i = 0 ; i < c.length ; i ++ ){
            System.out.print(c[i]);
            System.out.print(' ');
        }
        System.out.println();

        // 测试自定义的类 Student
        Student[] d = new Student[4];
        d[0] = new Student("D",90);
        d[1] = new Student("C",100);
        d[2] = new Student("B",95);
        d[3] = new Student("A",95);
        com.jcc.algorichms.algLiuyubo.Charter02.SelectionSort03.SelectionSort.sort(d);
        for( int i = 0 ; i < d.length ; i ++ ) {
            System.out.println(d[i]);
        }


        Arrays.sort(d);
    }
}
