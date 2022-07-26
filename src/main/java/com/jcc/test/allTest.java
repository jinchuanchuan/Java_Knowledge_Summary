package com.jcc.test;

import java.util.*;
import java.util.function.IntBinaryOperator;

import static java.lang.Long.sum;
import static java.lang.Math.max;

public class allTest {
    public static void main(String[] args) {
        int test = test();
        System.out.println(test);
//        int arr[] = {1,2,3,4,5,6,7};
//        int len = arr.length;
//
//        if (isIncrease(arr, len))
//            System.out.println("arr是递增数组");
//        else
//            System.out.println("arr不是递增数组");
//        System.out.println(test4());
    }

    public static int test() {
        int b = 20;
        try {
            System.out.println("try block");
            return b += 80;
        } catch (Exception e) {
            System.out.println("catch block");
        } finally {
            System.out.println("finally block");
            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }
            b = 150;
            System.out.println("此时的B=" + b);
        }
        return 2000;
    }

    public static boolean isIncrease(int[] a, int len) {
        if(len == 1) {
            return true;
        }
        return  a[len - 2] < a[len - 1] && isIncrease(a, len - 1);
    }
    public static int test4() {
        int b = 20;

        try {
            System.out.println("try block");

            b = b / 0;

            return b += 80;
        } catch (Exception e) {

            b += 15;
            System.out.println("catch block");
        } finally {

            System.out.println("finally block");

            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }

            b += 50;
        }

        return 204;
    }



























    int d[][] = {{-1,0},{0,-1},{1,0},{0,1}};
    int q, p;
    boolean[][] visited;
    int count = 0;

    public int movingCount(int m, int n, int k) {
        q = m;
        if(q == 0) {
            throw new IllegalArgumentException("board can not be empty.");
        }
        p = n;
        if(p == 0) {
            throw new IllegalArgumentException("board can not be empty.");
        }
        visited = new boolean[q][p];
        for(int i = 0; i < q; i++) {
            for(int j = 0; j < p; j++) {
                dfs(q, p, i, j, k);
            }
        }
        return count;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < q && y >=0 && y < p;
    }

    private void  dfs(int m, int n, int startX, int startY, int k) {
        if(k < getSum(startX) + getSum(startY)) {
            return ;
        }
        if(!inArea(startX, startY) || visited[startX][startY]) {
            return;
        }
        if(inArea(startX, startY) && !visited[startX][startY]) {
            visited[startX][startY] = true;
            count++;
            for(int a = 0; a < 4; a++) {
                int newX = startX + d[a][0];
                int newY = startY + d[a][1];
                dfs(m, n, newX, newY, k);
            }
        }
    }
    private int getSum(int a) {
        int sum = 0;
        int tmp = a;
        while(tmp > 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        return sum;
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null) {
            return 0;
        }
        int left = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                left = max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = max(max, i-left+1);
        }
        return max;
    }

    private void test01() {
        Deque<Integer> path = new LinkedList<Integer>();
        path.offerLast(1);
        IntBinaryOperator sum = (x, y) -> x + y;
        long sum1 = sum(1, 2);
        IntBinaryOperator max = Math::max;
        int max1 = max(1, 2);

    }








    
}
