package com.algorithm.findTwoNonOverlappingSubArraysEachWithTargetSum;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int start = 0, end = 0;
        int sum = arr[0];
        // key 为子数组和为target的开始坐标，vlaue为长度
        Map<Integer, Integer> map = new HashMap<>();
        while (start < arr.length) {
            while (sum < target) {
                end++;
                if (end >= arr.length) {
                    break;
                }
                sum += arr[end];
            }
            if (sum == target) {
                map.put(start, end - start + 1);
            }
            sum -= arr[start];
            start++;
        }
        int INFINITE = 100001;
        // dp[i] arr[i,arr.length-1] 范围内的子数组和为target的最小长度
        int[] dp = new int[arr.length];
        for (int i = dp.length - 1; i >= 0; i--) {
            dp[i] = Math.min(i + 1 == arr.length ? INFINITE : dp[i + 1], map.getOrDefault(i, INFINITE));
        }
        int res = INFINITE;


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int anotherSubBegin = entry.getKey() + entry.getValue();
            if (anotherSubBegin < arr.length && dp[anotherSubBegin] != INFINITE) {
                res = Math.min(res, entry.getValue() + dp[anotherSubBegin]);
            }
        }
        return res == INFINITE ? -1 : res;
    }
}