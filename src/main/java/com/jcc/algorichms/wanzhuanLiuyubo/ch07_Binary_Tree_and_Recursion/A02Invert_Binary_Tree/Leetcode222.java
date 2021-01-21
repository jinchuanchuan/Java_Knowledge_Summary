package com.jcc.algorichms.wanzhuanLiuyubo.ch07_Binary_Tree_and_Recursion.A02Invert_Binary_Tree;

import java.util.LinkedList;

/**
 * @program: javaknowledge->Leetcode222
 * @description: count
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-16 23:55
 **/
public class Leetcode222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 0;
        while(!q.isEmpty()) {
            TreeNode node = q.remove();
            count++;
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        return count;
    }
}
/**
 * Definition for a binary tree node.
 *
 **/
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