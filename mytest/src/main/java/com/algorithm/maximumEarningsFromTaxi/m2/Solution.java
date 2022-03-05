package com.algorithm.maximumEarningsFromTaxi.m2;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        // 以小于等于rides[i][1]为最后一趟的终点的最大盈利
        long[] dp = new long[n + 1];
        long maxEarnings = 0;
        Arrays.sort(rides, Comparator.comparingInt(r -> r[1]));
        for (int i = 0; i < rides.length; i++) {
            int nearestLastRideEnd = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (rides[j][1] <= rides[i][0]) {
                    nearestLastRideEnd = rides[j][1];
                    break;
                }
            }
            maxEarnings = Math.max(maxEarnings, (nearestLastRideEnd == -1 ? 0 : dp[nearestLastRideEnd]) + rides[i][1] - rides[i][0] + rides[i][2]);
            dp[rides[i][1]] = maxEarnings;
        }
        return maxEarnings;
    }
}