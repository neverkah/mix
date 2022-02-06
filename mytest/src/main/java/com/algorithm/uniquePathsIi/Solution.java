package com.algorithm.uniquePathsIi;

import java.util.Arrays;

class Solution {
    int[][] obstacleGrid;
    int M;
    int N;
    int[][] memo;
    int EMPTY = -1;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.obstacleGrid = obstacleGrid;
        M = obstacleGrid.length;
        N = obstacleGrid[0].length;
        memo = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(memo[i], EMPTY);
        }
        // dfs(i,j) 表示从坐标(i,j)到右下方的路径数
        return dfs(0, 0);
    }


    private int dfs(int i, int j) {
        if (memo[i][j] != EMPTY) {
            return memo[i][j];
        }

        if (obstacleGrid[i][j] == 1) {
            memo[i][j] = 0;
            return 0;
        }
        if (i == M - 1 && j == N - 1) {
            memo[i][j] = 1;
            return 1;
        }
        int path = 0;
        if (j + 1 < N && obstacleGrid[i][j + 1] == 0) {
            path += dfs(i, j + 1);
        }
        if (i + 1 < M && obstacleGrid[i + 1][j] == 0) {
            path += dfs(i + 1, j);
        }
        memo[i][j] = path;
        return path;
    }
}