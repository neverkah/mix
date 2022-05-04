package com.algorithm.minimumWindowSubstring;

class Solution2 {
    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] hash = new int[123];
        int left = 0, right = 0;
        int matchedNums = 0;
        for (char c : ct) {
            hash[c]--;
        }
        while (right < s.length() && s.length() - left >= t.length()) {
            char cr = cs[right];
            right++;
            if (hash[cr] < 0) {
                matchedNums++;
            }
            hash[cr]++;
            while (matchedNums == t.length()) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minLeft = left;
                }
                char cl = cs[left];
                if (hash[cl] <= 0) {
                    matchedNums--;
                }
                hash[cl]--;
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}