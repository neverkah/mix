package com.algorithm.addTwoNumbers;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;// 进位
        // 前一个节点
        ListNode lastListNode = null;
        ListNode head = null;
        while (l1 != null || l2 != null) {
            int add = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = add / 10;
            if (head == null) {
                head = lastListNode = new ListNode(add % 10);
            } else {
                lastListNode.next = new ListNode(add % 10);
                lastListNode = lastListNode.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            lastListNode.next = new ListNode(carry);
        }
        return head;
    }
}