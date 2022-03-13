package com.algorithm.longestSubstringWithoutRepeatingCharacters.m3;

import java.util.Arrays;

/**
 * 滑动窗口
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int begin = 0, end = 0;
        int[] map = new int[256];
        Arrays.fill(map, -1);
        char[] charArr = s.toCharArray();
        int res = 0;
        while (true) {
            while (end < length && (map[charArr[end]] < 0 || map[charArr[end]] < begin)) {
                map[charArr[end]] = end;
                end++;
            }
            res = Math.max(res, end - begin);
            if (end >= length - 1) {
                return res;
            }
            begin = map[charArr[end]] + 1;
            map[charArr[end]] = end;
            end++;
        }
    }
}