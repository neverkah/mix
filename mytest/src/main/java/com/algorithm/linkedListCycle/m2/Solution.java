package com.algorithm.linkedListCycle.m2;


//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class Solution {
    public static void main(String[] args) {
//        [3,2,0,-4]
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(-4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;

        System.out.println(new Solution().hasCycle(listNode1));

    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return  false;
        }
        ListNode slow = head, fast = head;
        do {
            slow = slow.next;
            if (fast.next == null) {
                break;
            }
            fast = fast.next.next;

        } while (fast != null && fast != slow);


        return fast == slow;
    }
}