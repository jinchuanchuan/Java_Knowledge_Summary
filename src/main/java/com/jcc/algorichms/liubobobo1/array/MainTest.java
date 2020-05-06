package com.jcc.algorichms.liubobobo1.array;

/**
 * @program: javaknowledge->MainTest
 * @description: main test
 * @author: jinchuanchuan1@le.com
 * @create: 2020-04-01 23:07
 **/
public class MainTest {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
            System.out.println(arr[i]);
        }

        int[] scores = new int[]{99, 88 ,66} ;

        for(int score : scores) {
            System.out.println(score);
        }
        scores[0] =  100;

        for(int i = 0; i < scores.length; i++) {
            System.out.println(scores[i]);
        }
    }
}
