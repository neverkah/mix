package com.algorithm.removeNthNodeFromEndOfList2;

import com.algorithm.ListNode;

/**
 * 双指针
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        // 删除节点的前一个节点
        ListNode removeNodePre = dummy;
        // 尾节点
        ListNode tail = head;
        for (int i = 0; i < n - 1; i++) {
            tail = tail.next;
        }
        while (tail.next != null) {
            tail = tail.next;
            removeNodePre = removeNodePre.next;
        }
        ListNode removeNode = removeNodePre.next;
        removeNodePre.next = removeNode.next;
        removeNode.next = null;
        return dummy.next;
    }
}
