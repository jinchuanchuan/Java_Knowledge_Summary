package com.jcc.algorichms.wanzhuansuanfayushujujiegouLiubobob.chapter05;

/**
 * @program: javaknowledge->LeetCode206
 * @description:
 * @author: jinchuanchuan1@le.com
 * @create: 2020-11-09 00:45
 **/
public class LeetCode206 {
    // Definition for singly-linked list.

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                // 反转
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
}
