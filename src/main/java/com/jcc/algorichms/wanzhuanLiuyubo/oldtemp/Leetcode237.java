package com.jcc.algorichms.wanzhuanLiuyubo.oldtemp;

/**
 * @program: javaknowledge->Leetcode237
 * @description: 改变值的思想
 * @author: jinchuanchuan1@le.com
 * @create: 2020-11-10 00:54
 **/
public class Leetcode237 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        // 表明node是最后一个接口，直接指向null就好
        if (node.next == null) {
            node = null;
            return;
        }

        // node节点后一个节点的值，复制到当前节点
        node.val = node.next.val;
        // 然后删除当前节点的下一个节点
        ListNode delNode = node.next;
        // 当前节点的指针指向要删除节点的下一个节点
        node.next = delNode.next;

        return;
    }
}
