package com.algorithm.longestSubstringWithoutRepeatingCharacters.m3;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int begin = 0, end = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] charArr = s.toCharArray();
        int res = 0;
        while (true) {
            while (end < length && (!map.containsKey(charArr[end]) || map.get(charArr[end]) < begin)) {
                map.put(charArr[end], end);
                end++;
            }
            res = Math.max(res, end - begin);
            if (end >= length - 1) {
                return res;
            }
            begin = map.get(charArr[end]) + 1;
            map.put(charArr[end], end);
            end++;
        }
    }
}