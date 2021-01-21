package com.jcc.algorichms.wanzhuanLiuyubo.ch06_Stack_and_Queue.A02_RecursionAndStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: javaknowledge->LeetCode94
 * @description:
 * @author: jinchuanchuan1@le.com
 * @create: 2021-01-19 15:32
 **/
public class LeetCode94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }
    public List<Integer> inorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorderTraversal(root.left, list);
            list.add(root.val);
            inorderTraversal(root.right, list);
        }
        return list;
    }
}
