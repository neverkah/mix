package com.algorithm.longestValidParentheses.mr;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    final static char LEFT_PARENTHESES = '(';

    public int longestValidParentheses(String s) {
        int longestLength = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == LEFT_PARENTHESES) {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                longestLength = Math.max(i - stack.peek(), longestLength);
            }
        }
        return longestLength;
    }
}