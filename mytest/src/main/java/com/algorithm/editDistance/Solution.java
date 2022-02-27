package com.algorithm.editDistance;

import java.util.Arrays;

class Solution {
    int EMPTY = -1;
    String word1;
    String word2;
    int[][] memo;

    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        memo = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], EMPTY);
        }
        return dfs(word1.length(), word2.length());
    }

    private int dfs(int i, int j) {
        if (memo[i][j] != EMPTY) {
            return memo[i][j];
        }
        if (i == 0) {
            memo[i][j] = j;
            return memo[i][j];
        }
        if (j == 0) {
            memo[i][j] = i;
            return memo[i][j];
        }
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            memo[i][j] = min(dfs(i, j - 1) + 1, dfs(i - 1, j) + 1, dfs(i - 1, j - 1));
        } else {
            memo[i][j] = min(dfs(i, j - 1) + 1, dfs(i - 1, j) + 1, dfs(i - 1, j - 1) + 1);
        }
        return memo[i][j];
    }

    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}