package com.algorithm.nonOverlappingIntervals;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        int len = intervals.length;
        // dp[i] 以intervals[i]为尾 区域不重叠 需要移除区间的最小数量
        int[] dp = new int[len];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (intervals[j][1] <= intervals[i][0]) {
                    break;
                }
            }
            dp[i] = (j < 0 ? 0 : dp[j]) + i - j - 1;
            res = Math.min(res, dp[i] + len - i - 1);
        }
        return res;
    }
}