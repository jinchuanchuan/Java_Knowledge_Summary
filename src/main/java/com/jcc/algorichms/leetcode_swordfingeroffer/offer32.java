package com.jcc.algorichms.leetcode_swordfingeroffer;

import com.geely.design.pattern.creational.singleton.T;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class offer32 {
    public static void main(String[] args) {

    }

    public int[] levelOrder(TreeNode root) {
        if(root == null) {
            return null;
        }
        ArrayList<Integer> array = new ArrayList<Integer>();
        //
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{add(root);}};
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            array.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] res = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            res[i] = array.get(i);
        }
        return res;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
