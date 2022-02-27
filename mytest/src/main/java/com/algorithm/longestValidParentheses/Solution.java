package com.algorithm.longestValidParentheses;

import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Character> stack = new Stack<>();
        int lastLength = 0;
        int currentLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    currentLength += 2;
                    if (stack.isEmpty()) {
                        lastLength += currentLength;
                        currentLength = 0;
                    }
                } else {
                    res = Math.max(res, lastLength);
                    lastLength = 0;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return Math.max(res, Math.max(lastLength, currentLength));
    }
}