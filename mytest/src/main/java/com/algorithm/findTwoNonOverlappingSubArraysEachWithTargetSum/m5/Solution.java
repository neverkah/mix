package com.algorithm.findTwoNonOverlappingSubArraysEachWithTargetSum.m5;

import java.util.HashMap;
import java.util.Map;

/**
 * 利用前缀和 进行动态规划
 */
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int N = arr.length;
        int preSum = 0;
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, -1);
        int[] dp = new int[N];
        int INF = N + 1;
        dp[0] = arr[0] == target ? 1 : INF;
        int minLen = INF;
        for (int i = 0; i < N; i++) {
            if (i > 0) {
                dp[i] = dp[i - 1];
            }
            preSum += arr[i];
            Integer subIndex = preSumMap.get(preSum - target);
            if (subIndex != null) {
                dp[i] = Math.min(dp[i], i - subIndex);
                if (subIndex > 0) {
                    minLen = Math.min(minLen, i - subIndex + dp[subIndex]);
                }
            }
            preSumMap.put(preSum, i);
        }
        return minLen >= INF ? -1 : minLen;
    }
}