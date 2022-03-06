package com.algorithm.liWuDeZuiDaJieZhiLcof;

class Solution {
    public int maxValue(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[][] dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = Math.max((i - 1 < 0 ? 0 : dp[i - 1][j]), (j - 1 < 0 ? 0 : dp[i][j - 1])) + grid[i][j];
            }
        }
        return dp[M - 1][N - 1];
    }
}