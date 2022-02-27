package com.algorithm.addTwoNumbers;

public class TT {

    public static void main(String[] args) {

//        2,4,3], l2 = [5,6,4]

        ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        new Solution().addTwoNumbers(listNode1,listNode2);

        System.out.println("----");
    }
}
