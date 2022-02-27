package com.algorithm.longestSubstringWithoutRepeatingCharacters.m2;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int begin = 0, end = 0;
        Set<Character> set = new HashSet<>();
        char[] charArr = s.toCharArray();
        int res = 0;
        while (end < length) {
            while (end < length && !set.contains(charArr[end])) {
                set.add(charArr[end]);
                end++;
            }
            res = Math.max(res, end - begin);
            begin++;
            set.remove(charArr[begin - 1]);
        }
        return res;
    }
}