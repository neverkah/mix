package com.algorithm.regularExpressionMatching;

class Solution {
    String s;
    String p;
    int[][] memo;

    int Y = 1, N = -1, EMPTY = 0;

    public static void main(String[] args) {
//        String s = "aab", p = "c*a*b";
        String s = "a", p = "ab*a";
        System.out.println(new Solution().isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        memo = new int[s.length() + 1][p.length() + 1];

        return isMatch(0, 0);
    }

    public boolean isMatch(int sIdx, int pIdx) {
        if (sIdx > s.length() || pIdx > p.length()) {
            return false;
        }
        if (memo[sIdx][pIdx] != EMPTY) {
            return memo[sIdx][pIdx] == Y;
        }
        if (sIdx == s.length() && pIdx == p.length()) {
            memo[sIdx][pIdx] = Y;
            return true;
        }
        if (pIdx == p.length() && sIdx < s.length()) {
            memo[sIdx][pIdx] = N;
            return false;
        }

        if (pIdx + 1 < p.length() && p.charAt(pIdx + 1) == '*') {
            if (p.charAt(pIdx) == '.') {
                for (int i = sIdx; i <= s.length(); i++) {
                    if (isMatch(i, pIdx + 2)) {
                        memo[sIdx][pIdx] = Y;
                        return true;
                    }
                }
            } else {
                for (int i = sIdx; i <= s.length(); i++) {
                    if (isMatch(i, pIdx + 2)) {
                        memo[sIdx][pIdx] = Y;
                        return true;
                    }
                    if (i < s.length() && s.charAt(i) != p.charAt(pIdx)) {
                        break;
                    }
                }
            }
            memo[sIdx][pIdx] = N;
            return false;
        }

        if (pIdx < p.length()) {
            if ((p.charAt(pIdx) == '.') || (sIdx < s.length() && s.charAt(sIdx) == p.charAt(pIdx))) {
                boolean matched = isMatch(sIdx + 1, pIdx + 1);
                memo[sIdx][pIdx] = isMatch(sIdx + 1, pIdx + 1) ? Y : N;
                return matched;
            }
        }
        memo[sIdx][pIdx] = N;
        return false;
    }
}