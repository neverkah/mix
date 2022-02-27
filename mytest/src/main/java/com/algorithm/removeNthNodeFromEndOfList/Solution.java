package com.algorithm.removeNthNodeFromEndOfList;

import com.algorithm.ListNode;

/**
 * 两次遍历
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 1;
        ListNode tail = head;
        while (tail.next != null) {
            size++;
            tail = tail.next;
        }
        // 删除头节点
        if (n == size) {
            ListNode newHead = head.next;
            head.next = null;
            return newHead;
        }
        // 获取删除节点的前一个节点
        ListNode removeNodePre = head;
        for (int i = 1; i < size - n; i++) {
            removeNodePre = removeNodePre.next;
        }
        // 删除尾节点
        if (n == 1) {
            removeNodePre.next = null;
            return head;
        }
        // 删除中间节点
        ListNode removeNode = removeNodePre.next;
        ListNode removeNodeNext = removeNode.next;
        removeNodePre.next = removeNodeNext;
        removeNode.next = null;
        return head;
    }
}