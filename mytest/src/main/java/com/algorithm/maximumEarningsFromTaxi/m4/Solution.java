package com.algorithm.maximumEarningsFromTaxi.m4;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        //dp[i] 表示从1开到i位置的最大盈利
        long[] dp = new long[n + 1];
        long maxEarnings = 0;
        Arrays.sort(rides, Comparator.comparingInt(r -> r[1]));
        int rIndex = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1];
            while (rIndex < rides.length && rides[rIndex][1] == i) {
                dp[i] = Math.max(dp[i], dp[rides[rIndex][0]] + rides[rIndex][1] - rides[rIndex][0] + rides[rIndex][2]);
                rIndex++;
            }
        }
        return dp[n];
    }
}