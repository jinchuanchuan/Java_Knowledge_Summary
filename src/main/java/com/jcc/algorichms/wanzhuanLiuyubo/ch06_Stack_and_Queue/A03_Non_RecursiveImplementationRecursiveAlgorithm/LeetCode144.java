package com.jcc.algorichms.wanzhuanLiuyubo.ch06_Stack_and_Queue.A03_Non_RecursiveImplementationRecursiveAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: javaknowledge->LeetCode144
 * @description: 递归的前序遍历
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-19 15:30
 **/
public class LeetCode144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
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
