package com.algorithm.linkedListCycle;


import java.util.HashSet;
import java.util.Set;

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
    public boolean hasCycle(ListNode head) {
        Set<ListNode> listNodeSet = new HashSet<>();
        while (head != null) {
            if (listNodeSet.contains(head)) {
                return  true;
            }
            listNodeSet.add(head);
            head = head.next;
        }

        return true;
    }
}