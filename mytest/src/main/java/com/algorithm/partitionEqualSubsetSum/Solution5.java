package com.algorithm.partitionEqualSubsetSum;

class Solution5 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxNum = Math.max(maxNum, nums[i]);
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        if (maxNum > sum) {
            return false;
        }
        boolean[][] dp = new boolean[nums.length][sum + 1];
        for (int j = 0; j <= sum; j++) {
            dp[0][j] = nums[0] == sum || j == 0;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = j == 0 || dp[i - 1][j - nums[i]] || dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][sum];
    }
}