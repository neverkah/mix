package com.algorithm.longestPalindromicSubstring;

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int longestStart = 0, longestEnd = 0;
        char[] charArray = s.toCharArray();
        for (int end = 0; end < s.length(); end++) {
            for (int start = 0; start < end; start++) {
                dp[start][end] = charArray[start] == charArray[end] && (start + 1 >= end - 1 || dp[start + 1][end - 1]);
                if (dp[start][end] && end - start > longestEnd - longestStart) {
                    longestStart = start;
                    longestEnd = end;
                }
            }
        }
        return s.substring(longestStart, longestEnd + 1);
    }
}