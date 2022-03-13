package com.algorithm.longestSubstringWithoutRepeatingCharacters;

import java.util.Arrays;

/**
 * 动态规划
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // 以s[i-1]结尾的最长无重复子串的长度
        int dp = 0;
        // 字符出现的最大的下标
        int[] map = new int[256];
        Arrays.fill(map, -1);
        char[] charArr = s.toCharArray();
        int res = 0;
        for (int i = 0; i < charArr.length; i++) {
            dp = Math.min(i - map[charArr[i]], dp + 1);
            res = Math.max(res, dp);
            map[charArr[i]] = i;
        }
        return res;
    }
}