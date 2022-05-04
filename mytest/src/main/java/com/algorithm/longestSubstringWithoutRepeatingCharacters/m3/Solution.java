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

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring2("abcd"));
    }

    public int lengthOfLongestSubstring2(String s) {
        int length = s.length();
        int left = 0, right = 0;
        int[] map = new int[128];
        Arrays.fill(map, -1);
        char[] charArr = s.toCharArray();
        int res = 0;
        while (right < s.length()) {
            map[charArr[right]] = right;
            right++;
            while (left < right && (right == s.length() || map[charArr[right]] >= left)) {
                res = Math.max(res, right - left);
                if (right == s.length()) {
                    break;
                }
                left = map[charArr[right]] + 1;
            }
        }
        return res;
    }
}