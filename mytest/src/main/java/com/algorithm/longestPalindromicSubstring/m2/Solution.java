package com.algorithm.longestPalindromicSubstring.m2;

class Solution {
    boolean[][] memo;
    boolean[][] known;
    char[] charArray;

    public boolean longestPalindrome(int start, int end) {
        if (known[start][end]) {
            return memo[start][end];
        }
        if (start >= end) {
            memo[start][end] = true;
            known[start][end] = true;
            return memo[start][end];
        }
        memo[start][end] = charArray[start] == charArray[end] && longestPalindrome(start + 1, end - 1);
        known[start][end] = true;
        return memo[start][end];
    }

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        this.charArray = s.toCharArray();
        memo = new boolean[s.length()][s.length()];
        known = new boolean[s.length()][s.length()];
        int pStart = 0, maxLen = 1;
        for (int end = 0; end < charArray.length; end++) {
            for (int start = 0; start <= end - maxLen; start++) {
                if (longestPalindrome(start, end)) {
//                    if (start <= 1) {
//                        return s.substring(start, end + 1);
//                    }
                    pStart = start;
                    maxLen = end - start + 1;
                }
            }
        }
        return s.substring(pStart, pStart + maxLen);
    }
}