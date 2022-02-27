package com.algorithm.maximumAbsoluteSumOfAnySubarray.m2;

/**
 * 前缀和
 */
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0, minSum = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            maxSum = Math.max(maxSum, sum);
            minSum = Math.min(minSum, sum);
        }
        return Math.abs(maxSum - minSum);
    }
}