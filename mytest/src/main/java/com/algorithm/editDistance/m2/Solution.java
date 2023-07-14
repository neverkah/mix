package com.algorithm.editDistance.m2;

class Solution {
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(new Solution().minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}