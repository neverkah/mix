package com.algorithm.minimumPathSum;

import java.util.Arrays;

class Solution5 {

    private int M;
    private int N;
    private int[][] memo;
    private int[][] grid;

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Solution5().minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {

        this.grid = grid;
        M = grid.length;
        N = grid[0].length;
        memo = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(memo[i], -1);
        }
        return minPathSum(M - 1, N - 1);
    }

    public int minPathSum(int i, int j) {

        if (memo[i][j] > -1) {
            return memo[i][j];
        }

        if (i == 0 && j == 0) {
            memo[i][j] = grid[0][0];
            return memo[i][j];
        }
        int result = Integer.MAX_VALUE;
        if (i - 1 >= 0) {
            result = Math.min(result, minPathSum(i - 1, j));
        }
        if (j - 1 >= 0) {
            result = Math.min(result, minPathSum(i, j - 1));
        }

        memo[i][j] = result + grid[i][j];
        return memo[i][j];
    }
}
