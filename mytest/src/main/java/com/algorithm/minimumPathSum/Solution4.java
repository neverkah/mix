package com.algorithm.minimumPathSum;

import java.util.Arrays;

class Solution4 {
    private int M;
    private int N;
    private int[][] memo;
    private int[][] grid;


    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Solution().minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {

        this.grid = grid;
        M = grid.length;
        N = grid[0].length;
        memo = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(memo[i], -1);
        }
        return minPathSum(grid.length - 1, grid[0].length - 1);
    }


    public int minPathSum(int i, int j) {

        //若越界，则认为不可达，距离为无穷大
        if (i < 0 || i >= M || j < 0 || j >= N) return Integer.MAX_VALUE;


        if (i == 0 && j == 0) {
            return grid[0][0];
        }

        if (memo[i][j] > -1) {
            return memo[i][j];
        }
        memo[i][j] = Math.min(minPathSum(i, j - 1), minPathSum(i - 1, j)) + grid[i][j];
        return memo[i][j];

    }

}

