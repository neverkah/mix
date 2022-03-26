package com.algorithm.maximumEarningsFromTaxi.m3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        //  key:乘客订单的终点 value:(乘客订单的起点，乘客订单的小费)的list
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] ride : rides) {
            if (map.containsKey(ride[1])) {
                map.get(ride[1]).add(new int[]{ride[0], ride[2]});
            } else {
                List<int[]> startTips = new ArrayList<>();
                startTips.add(new int[]{ride[0], ride[2]});
                map.put(ride[1], startTips);
            }
        }
        // dp[i] 表示从1开到i位置的最大盈利
        long[] dp = new long[n + 1];
        for (int i = 2; i <= n; i++) {
            // 表示没有乘客从i位置下车的最大盈利
            long maxi = dp[i - 1];

            // 计算有乘客从i位置下车的最大盈利
            if (null != map.get(i)) {
                for (int[] startTip : map.get(i)) {
                    maxi = Math.max(maxi, dp[startTip[0]] + i - startTip[0] + startTip[1]);
                }
            }
            dp[i] = maxi;
        }
        return dp[n];
    }
}