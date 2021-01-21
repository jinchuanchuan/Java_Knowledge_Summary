package com.jcc.algorichms.leetcode_swordfingeroffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: javaknowledge->offer06
 * @description: 从尾到头打印链表
 * @author: jinchuanchuan1@le.com
 * @create: 2020-12-16 20:17
 **/
public class offer06 {
    public int[] reversePrint(ListNode head) {
        // 第一步：反转链表，得到反转后的链表pre
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 第二步：遍历链表，存到list后再放到数组中返回。
        List list = new ArrayList();
        while (pre.next !=null) {
            list.add(pre.val);
            pre = pre.next;
        }
        int[] arr =  new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = (Integer) list.get(i);
        }
        return arr;
    }
    // 回溯法 -- 精选回答

    // 辅助堆栈法 -- 精选回答

    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
