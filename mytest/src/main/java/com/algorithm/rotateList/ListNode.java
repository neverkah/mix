package com.algorithm.rotateList;

import java.util.ArrayList;
import java.util.List;

//  Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (null == head || k == 0) {
            return head;
        }
        List<ListNode> listNodes = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            listNodes.add(node);
            node = node.next;
        }
        if (k % listNodes.size() == 0) {
            return head;
        }
        int newHeadIndex = listNodes.size() - k % listNodes.size();
        listNodes.get(newHeadIndex - 1).next = null;
        listNodes.get(listNodes.size() - 1).next = listNodes.get(0);
        return listNodes.get(newHeadIndex);
    }
}