package com.jcc.algorichms.wanzhuanLiuyubo.ch06_Stack_and_Queue.A02_RecursionAndStack;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: javaknowledge->LeetCode144
 * @description: 递归的前序遍历
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-19 15:30
 **/
public class LeetCode144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arrList = new ArrayList<>();
        if (root == null) {
                return arrList;
            }
        if (root != null) {
            preorderTraversal(root, arrList);
        }
        return arrList;
    }
    public List<Integer> preorderTraversal(TreeNode root, List<Integer> arrList) {
        if (root != null) {
            arrList.add(root.val);
            preorderTraversal(root.left, arrList);
            preorderTraversal(root.right, arrList);
        }
        return arrList;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,2,3};

    }
}

// Definition for a binary tree node.

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
     }
 }
