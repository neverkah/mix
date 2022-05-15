package com.algorithm.findTwoNonOverlappingSubArraysEachWithTargetSum.m3;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int N = arr.length;
        int left = 0, right = 0;
        int sum = 0;
        int[] dp = new int[N];
        int INF = N + 1;
        dp[0] = arr[0] == target ? 1 : INF;
        int minLen = INF;
        while (right < N) {
            if (right > 0) {
                dp[right] = dp[right - 1];
            }
            sum += arr[right];
            while (sum >= target) {
                if (sum == target) {
                    int len = right - left + 1;
                    dp[right] = Math.min(dp[right], len);
                    if (left > 0) {
                        minLen = Math.min(minLen, len + dp[left - 1]);
                    }
                }
                sum -= arr[left];
                left++;
            }
            right++;
        }
        return minLen >= INF ? -1 : minLen;
    }
}