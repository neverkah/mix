package com.algorithm.closestSubsequenceSum;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Long, Integer> memo;
    int[] nums;

    public int minAbsDifference(int[] nums, int goal) {
        this.nums = nums;
        this.memo = new HashMap<>();
        return dfs(nums.length - 1, goal);
    }

    int dfs(int end, long goal) {
        if (memo.containsKey(goal * 100 + end)) {
            return memo.get(goal * 100 + end);
        }
        int res = 0;
        if (end == 0) {
            res = (int) Math.min(Math.abs(goal), Math.abs(goal - nums[0]));
            memo.put(goal * 100 + end, res);
            return res;
        }
        res = Math.min(dfs(end - 1, goal - nums[end]), dfs(end - 1, goal));
        memo.put(goal * 100 + end, res);
        return res;
    }
}