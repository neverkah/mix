package com.algorithm.findTwoNonOverlappingSubArraysEachWithTargetSum.m2;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int start = 0, end = 0;
        int sum = arr[0];
        int INFINITE = 100001;
        // dp[i] arr[0,i] 范围内子数组和为target的最小长度
        int[] dp = new int[arr.length];
        dp[0] = arr[0] == target ? 1 : INFINITE;
        int minLength = INFINITE;
        while (start < arr.length) {
            while (sum < target) {
                end++;
                if (end >= arr.length) {
                    break;
                }
                sum += arr[end];
                dp[end] = Math.min(end - 1 < 0 ? INFINITE : dp[end - 1], sum == target ? end - start + 1 : INFINITE);
            }
            if (sum == target) {
                if (start - 1 >= 0 && dp[start - 1] != INFINITE) {
                    minLength = Math.min(minLength, dp[start - 1] + end - start + 1);
                }
                dp[end] = Math.min(end - 1 < 0 ? INFINITE : dp[end - 1], end - start + 1);
            }
            sum -= arr[start];
            start++;
        }
        return minLength == INFINITE ? -1 : minLength;
    }
}