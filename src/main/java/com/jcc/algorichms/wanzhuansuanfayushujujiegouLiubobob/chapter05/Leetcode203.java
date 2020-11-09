package com.jcc.algorichms.wanzhuansuanfayushujujiegouLiubobob.chapter05;

import java.util.LinkedHashMap;

/**
 * @program: javaknowledge->Leetcode203
 * @description: 虚拟头节点
 * @author: jinchuanchuan1@le.com
 * @create: 2020-11-10 00:17
 **/
public class Leetcode203 {
    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = delNode.next;
        }

        if (head == null) {
            return head;
        }

        ListNode cur = head;

        while (cur.next != null) {
            if (cur.next.val == val) {
                ListNode delNode = cur.next;
                cur.next = delNode.next;
            } else  {
                cur = cur.next;
            }
        }

        return head;
    }
    // 虚拟头节点
    public ListNode removeElementsDummyHead(ListNode head, int val) {
        // 虚拟头节点
        ListNode dummyHead = new ListNode(0);
        // 虚拟头节点指向head，形成链表
        dummyHead.next = head;

        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                ListNode delNode = cur.next;
                cur.next = delNode.next;
            } else  {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
