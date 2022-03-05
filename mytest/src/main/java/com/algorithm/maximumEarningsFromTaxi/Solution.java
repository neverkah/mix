package com.algorithm.maximumEarningsFromTaxi;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        // 以小于等于rides[i][1]为最后一趟的终点的最大盈利
        long[] dp = new long[n + 1];
        long maxEarnings = 0;
        Arrays.sort(rides, Comparator.comparingInt(r -> r[1]));
        for (int i = 0; i < rides.length; i++) {
            int nearestLastRide = binarySearch(rides, 0, i - 1, rides[i][0]);
            maxEarnings = Math.max(maxEarnings, (nearestLastRide == -1 ? 0 : dp[nearestLastRide]) + rides[i][1] - rides[i][0] + rides[i][2]);
            dp[rides[i][1]] = maxEarnings;
        }
        return maxEarnings;
    }

    /**
     * 存在与key相等的元素，返回key
     * 找不到相等的，返回比key小最大的元素
     */
    public int binarySearch(int[][] nums, int start, int end, int key) {
        if (end < 0) {
            return -1;
        }
        if (key >= nums[end][1]) {
            return nums[end][1];
        }
        if (key < nums[start][1]) {
            return -1;
        } else if (key == nums[start][1]) {
            return key;
        }
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid][1] < key) {
                start = mid + 1;
            } else if (nums[mid][1] > key) {
                end = mid - 1;
            } else {
                return key;
            }
        }
        return nums[end][1];
    }
}