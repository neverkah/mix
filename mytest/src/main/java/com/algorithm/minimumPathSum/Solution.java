package com.algorithm.minimumPathSum;

class Solution {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Solution().minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] result = new int[n];



        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    result[j] = grid[0][0];
                    continue;
                }
                int temp = Integer.MAX_VALUE;

                if (j - 1 >= 0) {
                    temp = Math.min(temp, result[j - 1] + grid[i][j]);
                }
                if (i - 1 >= 0) {
                    temp = Math.min(temp, result[j] + grid[i][j]);
                }
                result[j] = temp;
            }
        }
        return result[n - 1];
    }
}