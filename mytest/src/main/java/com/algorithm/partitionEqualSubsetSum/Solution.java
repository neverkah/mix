package com.algorithm.partitionEqualSubsetSum;

class Solution {
    int[] nums;
    int halfSum;
    int[] accumu;
    int[][] memo;
    int Y = 1, N = -1, EMPTY = 0;

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5};
        System.out.println(new Solution().canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        this.nums = nums;
        this.accumu = new int[nums.length];
        accumu[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            accumu[i] = accumu[i - 1] + nums[i];
        }
        if (accumu[nums.length - 1] % 2 != 0) {
            return false;
        }
        halfSum = accumu[nums.length - 1] / 2;
        this.memo = new int[nums.length][halfSum + 1];
        return dfs(nums.length - 1, halfSum);
    }

    private boolean dfs(int endIndex, int sum) {

        if (memo[endIndex][sum] != EMPTY) {
            return memo[endIndex][sum] == Y;
        }

        for (int i = endIndex; i >= 0; i--) {
            if (i == 0) {
                boolean res = nums[i] == sum;
                memo[endIndex][sum] = res ? Y : N;
                return res;
            }
            if (sum - nums[i] == 0 || (sum - nums[i] > 0 && accumu[i - 1] >= sum - nums[i] && dfs(i - 1, sum - nums[i]))) {
                memo[endIndex][sum] = Y;
                return true;
            }
        }
        memo[endIndex][sum] = N;
        return false;
    }
}