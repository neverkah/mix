package com.algorithm.minimumWindowSubstring;

class Solution {
    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] countS = new int[123];
        int[] countT = new int[123];
        int left = 0, right = 0;
        int matchedNums = 0;
        int targetNums = 0;
        for (char c : ct) {
            if (countT[c] == 0) {
                targetNums++;
            }
            countT[c]++;
        }
        for (left = 0; s.length() - left >= t.length(); left++) {
            while (right < s.length() && matchedNums < targetNums) {
                countS[cs[right]]++;
                if (countS[cs[right]] == countT[cs[right]]) {
                    matchedNums++;
                }
                right++;
            }
            if (matchedNums == targetNums) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minLeft = left;
                }
                if (countT[cs[left]] > 0) {
                    countS[cs[left]]--;
                    if (countS[cs[left]] < countT[cs[left]]) {
                        matchedNums--;
                    }
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}