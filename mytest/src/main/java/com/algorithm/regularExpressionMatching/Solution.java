package com.algorithm.regularExpressionMatching;

import java.util.Arrays;

class Solution {
    String s;
    String p;
    int[][] memo;

    public static void main(String[] args) {
//        String s = "aab", p = "c*a*b";
        String s = "a", p = "ab*a";
        System.out.println(new Solution().isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        memo = new int[s.length() + 1][p.length() + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return isMatch(0, 0);
    }

    public boolean isMatch(int sIdx, int pIdx) {
        if (sIdx > s.length() || pIdx > p.length()) {
            return false;
        }
        if (memo[sIdx][pIdx] > -1) {
            return memo[sIdx][pIdx] == 1;
        }
        if (sIdx == s.length() && pIdx == p.length()) {
            memo[sIdx][pIdx] = 1;
            return true;
        }
        if (pIdx == p.length() && sIdx < s.length()) {
            memo[sIdx][pIdx] = 0;
            return false;
        }

        if (pIdx + 1 < p.length() && p.charAt(pIdx + 1) == '*') {
            if (p.charAt(pIdx) == '.') {
                for (int i = sIdx; i <= s.length(); i++) {
                    if (isMatch(i, pIdx + 2)) {
                        memo[sIdx][pIdx] = 1;
                        return true;
                    }
                }
            } else {
                for (int i = sIdx; i <= s.length(); i++) {
                    if (isMatch(i, pIdx + 2)) {
                        memo[sIdx][pIdx] = 1;
                        return true;
                    }
                    if (i < s.length() && s.charAt(i) != p.charAt(pIdx)) {
                        break;
                    }
                }
            }
            memo[sIdx][pIdx] = 0;
            return false;
        }

        if (pIdx < p.length()) {
            if ((p.charAt(pIdx) == '.') || (sIdx < s.length() && s.charAt(sIdx) == p.charAt(pIdx))) {
                boolean matched = isMatch(sIdx + 1, pIdx + 1);
                memo[sIdx][pIdx] = matched ? 1 : 0;
                return matched;
            }
        }
        memo[sIdx][pIdx] = 0;
        return false;
    }
}