package com.algorithm.longestValidParentheses.m3;

class Solution {
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int longestLength = 0;
        for (int k = 0; k < chars.length; k++) {
            int length = 0;
            int leftBrackets = 0;
            int leftMinusRight = 0;
            for (int i = k; i < chars.length; i++) {
                if (leftMinusRight == 0 && chars[i] == ')') {
                    break;
                }
                leftMinusRight += chars[i] == '(' ? 1 : -1;
                leftBrackets += chars[i] == '(' ? 1 : 0;
                if (leftMinusRight == 0) {
                    length += leftBrackets * 2;
                    leftBrackets = 0;
                }
            }
            longestLength = Math.max(longestLength, length);
            if (length > 0) {
                k = k + length;
            }
        }
        return longestLength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses(")()())"));
    }
}