package com.algorithm.mergeIntervals;

import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x1, x2) -> {
            return x1[0] - x2[0];
        });
        int[][] res = new int[intervals.length][2];
        int index = 0;
        int start = intervals[0][0];
        int end = intervals[0][1];
        int N = intervals.length;
        for (int i = 1; i < N; i++) {
            if (intervals[i][0] <= end) {
                if (intervals[i][1] > end) {
                    end = intervals[i][1];
                }
            } else {
                res[index++] = new int[]{start, end};
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res[index++] = new int[]{start, end};
        return Arrays.copyOf(res, index);
    }
}