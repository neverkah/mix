package com.algorithm.maximumAlternatingSubsequenceSum;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        // 以nums[i]结尾的子序列大小为奇数的最大交替和
        long oddMax = nums[0];
        // 以nums[i]结尾的子序列大小为偶数数的最大交替和
        long evenMax = 0;
        for (int i = 1; i < nums.length; i++) {
            long evenMaxBefore = evenMax;
            evenMax = Math.max(evenMax, oddMax - nums[i]);
            oddMax = Math.max(oddMax, Math.max(evenMaxBefore + nums[i], nums[i]));
        }
        return Math.max(oddMax, evenMax);
    }
}