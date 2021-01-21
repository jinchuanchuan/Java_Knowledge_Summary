package com.jcc.algorichms.wanzhuanLiuyubo.ch07_Binary_Tree_and_Recursion.A01Maximum_Depth_of_Binary_Tree;

/**
 * @program: javaknowledge->Leetcode104
 * @description: Maximum Depth of Binary Tree
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-16 21:44
 **/
public class Leetcode104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeftDepth = maxDepth(root.left);
        int maxRightDepth = maxDepth(root.right);
        return Math.max(maxLeftDepth, maxRightDepth) + 1;
    }
}


// Definition for a binary tree node.

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
