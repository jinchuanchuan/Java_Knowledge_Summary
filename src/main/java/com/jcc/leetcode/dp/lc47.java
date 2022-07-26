package com.jcc.leetcode.dp;

import java.util.*;

public class lc47 {
    public static void main(String[] args) {
//        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] grid = {{1,2,5},{3,2,1}};
        System.out.println(maxValue(grid));
    }

    public static int maxValue(int[][] grid) {
        int res = grid[0][0] ;
        int i = 0;
        int j = 0;
        int m = grid.length, n = grid[0].length;
        while(i < m && j < n) {
            if(i == m - 1 && j == n-1) {
                return res;
            }
            if(i == m - 1 && j < n-1) {
                res+=grid[i][j+1];
                j++;
            } else if(i < m - 1 && j == n-1) {
                res += grid[i+1][j];
                i++;
            } else if(grid[i][j+1] > grid[i+1][j]) {
                res+=grid[i][j+1];
                j++;
            } else {
                res += grid[i+1][j];
                i++;
            }
        }
        return res;
    }
    private Set<String> rec;
    boolean[] vis;
    private void generatePermutation(String s, int index, StringBuffer res) {
        if(s.length() == index) {
            rec.add(res.toString());
        }
        for(int i = 0; i < s.length(); i++) {
            if(!vis[i]) {
                vis[i] = true;
                res.append(s.charAt(i));
                generatePermutation(s, index+1, res);
                vis[i] = false;
                res.deleteCharAt(res.length() - 1);
            }
        }
        return;
    }
    public String[] permutation(String s) {
        if(s==null) {
            return null;
        }
        int n = s.length();
        rec = new HashSet<>();
        vis = new boolean[n];
        StringBuffer perm = new StringBuffer();
        generatePermutation(s, 0, perm);

        int size = rec.size();
        String[] recArr = new String[size];
        Iterator<String> iterator = rec.iterator();
        for (int i = 0; i < size; i++) {
            if (iterator.hasNext()) {
                recArr[i] = iterator.next();
            }
        }
        return recArr;
    }
}
