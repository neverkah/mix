package com.algorithm.rotateList2;

//  Definition for singly-linked list.

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (null == head || k == 0) {
            return head;
        }
        ListNode tail = head;
        int size = 1;
        while (tail.next != null) {
            size++;
            tail = tail.next;
        }
        if (k % size == 0) {
            return head;
        }
        int newHeadIndex = size - k % size;
        ListNode newTail = head;
        for (int i = 0; i < newHeadIndex - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;
        return newHead;
    }
}