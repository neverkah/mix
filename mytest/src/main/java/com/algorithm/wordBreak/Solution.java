package com.algorithm.wordBreak;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    List<String> wordDict;
    String s;
    Set<String> wordSet;
    int[][] memo;
    int EMPTY = 0, Y = 1, N = -1;

    public static void main(String[] args) {
        String[] strArr = new String[]{"apple", "pen"};
        List<String> strList = Arrays.asList(strArr);
        String s = "applepenapple";
        Solution solution = new Solution();
        System.out.println(solution.wordBreak(s, strList));
        System.out.println("-----");
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
        this.memo = new int[s.length()][s.length() + 1];
        wordSet = new HashSet<>(wordDict.size());
        wordSet.addAll(wordDict);
        return wordBreak(0, s.length());
    }

    public boolean wordBreak(int begin, int length) {
        if (memo[begin][length] != EMPTY) {
            return memo[begin][length] == Y;
        }
        for (int step = length; step >= 1; step--) {
            String prefix = s.substring(begin, begin + step);
            if (wordSet.contains(prefix)) {
                boolean matched = step == length || wordBreak(begin + step, length - step);
                if (matched) {
                    memo[begin][length] = Y;
                    return true;
                }
            }
        }
        memo[begin][length] = N;
        return false;
    }
}