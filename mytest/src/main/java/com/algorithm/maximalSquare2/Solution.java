package com.algorithm.maximalSquare2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Solution {
    public static void main(String[] args) {

        //1 <= m, n <= 300

        int  testTimes = 10000;
        Solution s2 = new Solution();
        com.algorithm.maximalSquare.Solution s = new com.algorithm.maximalSquare.Solution();
        List<char[][]> lst = new ArrayList<>();

        for (int i = 0; i < testTimes; i++) {
            char[][] matrix = genMatrix();

            lst.add(matrix);
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < testTimes; i++) {
            char[][] matrix = lst.get(i);
            s2.maximalSquare(matrix);
        }
        long end = System.currentTimeMillis();
        System.out.println("s2 method sovled " + (end - start) + " ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < testTimes; i++) {
            char[][] matrix = lst.get(i);
            s.maximalSquare(matrix);
        }
        end = System.currentTimeMillis();

        System.out.println("s method sovled " + (end - start) + " ms");


    }

    private static char[][] genMatrix() {
        Random r = new Random();
        int m = r.nextInt(300) + 1;
        int n = r.nextInt(300) + 1;

        char[][] matrix = new char[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (r.nextInt(2) == 0) {
                    matrix[i][j] = '0';
                } else {
                    matrix[i][j] = '1';
                }

            }
        }

        return matrix;
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int M = matrix.length;
        int N = matrix[0].length;
        int[] dp = new int[N + 1];
        int result = 0;
        for (int i = 1; i <= M; i++) {
            int prev = 0;
            for (int j = 1; j <= N; j++) {
                int t = dp[j];
                if (matrix[i - 1][j - 1] == '0') {
                    dp[j] = 0;
                    continue;
                }
                dp[j] = Math.min(dp[j - 1], Math.min(dp[j], prev)) + 1;
                prev = t;
                result = Math.max(result, dp[j]);
            }
        }
        return result * result;
    }
}

