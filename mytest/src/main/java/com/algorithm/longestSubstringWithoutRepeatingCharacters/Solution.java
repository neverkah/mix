package com.algorithm.longestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态规划
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // 以s[i-1]结尾的最长无重复子串的开始下标
        int dp = 0;
        // 字符出现的最大的下标
        Map<Character, Integer> map = new HashMap<>();
        char[] charArr = s.toCharArray();
        int res = 0;
        for (int i = 0; i < charArr.length; i++) {
            Integer repeatIdx = map.get(charArr[i]);
            if (repeatIdx != null && repeatIdx >= dp) {
                dp = repeatIdx + 1;
            } else {
                res = Math.max(res, i - dp + 1);
            }
            map.put(charArr[i], i);
        }
        return res;
    }
}