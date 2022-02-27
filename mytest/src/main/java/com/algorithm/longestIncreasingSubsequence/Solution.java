package com.algorithm.longestIncreasingSubsequence;

class Solution {
    public int lengthOfLIS(int[] nums) {
        // 以nums[i]为最后元素的最长递增子序列长度
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}