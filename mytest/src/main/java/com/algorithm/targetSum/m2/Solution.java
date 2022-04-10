package com.algorithm.targetSum.m2;

class Solution {
    int[] nums;
    int[][] memo;
    int sum;

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        this.sum = sum;
        this.nums = nums;
        int N = nums.length;
        this.memo = new int[N][2 * sum + 1];
        return dfs(N - 1, target);
    }

    private int dfs(int index, int target) {
        if (target < -sum || target > sum) {
            return 0;
        }

        if (memo[index][target + sum] > 0) {
            return memo[index][target + sum] - 1;
        }

        if (index == 0) {
            memo[index][target + sum] = (nums[index] == target ? 1 : 0) + (-nums[index] == target ? 1 : 0) + 1;
            return memo[index][target + sum] - 1;
        }
        memo[index][target + sum] = dfs(index - 1, target + nums[index]) + dfs(index - 1, target - nums[index]) + 1;
        return memo[index][target + sum] - 1;
    }
}