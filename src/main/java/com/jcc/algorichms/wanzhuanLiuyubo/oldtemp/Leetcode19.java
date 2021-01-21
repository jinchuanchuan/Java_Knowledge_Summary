package com.jcc.algorichms.wanzhuanLiuyubo.oldtemp;

/**
 * @program: javaknowledge->Leetcode19
 * @description: 双索引，滑动窗口技术
 * @author: jinchuanchuan1@le.com
 * @create: 2020-11-10 01:21
 **/
public class Leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode p = dummyNode;
        ListNode q = dummyNode;
        // 找到p和q之间的距离n，为下面循环找p节点做准备
        for (int i = 0; i < n +1; i++) {
            q = q.next;
        }
        // 当循环终止，p就是要删除节点的上一个节点
        while (q != null) {
            p = q.next;
            q = q.next;
        }
        // 删除操作
        ListNode delNode = p.next;
        p.next =  delNode.next;
        return dummyNode.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
