package com.algorithm.perfectSquares;

class Solution {
    public int numSquares(int target) {
        int[] dp = new int[target + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i * i <= target; i++) {
            int num = i * i;
            for (int j = num; j <= target; j++) {
                dp[j] = Math.min(dp[j], dp[j - num] + 1);
            }
        }
        return dp[target];
    }

    private int dfs(int num, int target) {
        if (target == 0) {
            return 0;
        }
        if (num == 1) {
            return target == 1 ? 1 : Integer.MAX_VALUE;
        }
        int chooseNum = Integer.MAX_VALUE;
        if (target - num * num >= 0) {
            chooseNum = dfs(num - 1, target - num * num);
            if (chooseNum != Integer.MAX_VALUE) {
                chooseNum = chooseNum + 1;
            }
        }
        return Math.min(dfs(num - 1, target), chooseNum);
    }
}