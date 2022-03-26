package com.algorithm.partitionEqualSubsetSum;

class Solution4 {
    int[] nums;
    int sum;
    boolean[][] memo;
    boolean[][] memoTag; // 表示是否已计算

    public boolean canPartition(int[] nums) {
        this.nums = nums;
        int sum = 0;
        int maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxNum = Math.max(maxNum, nums[i]);
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        this.sum = sum;
        if (maxNum > this.sum) {
            return false;
        }
        this.memo = new boolean[nums.length][this.sum + 1];
        this.memoTag = new boolean[nums.length][this.sum + 1];
        return dfs(nums.length - 1, this.sum);
    }

    //  nums[0,endIndex] 范围内的数字，能否相加凑成sum
    private boolean dfs(int endIndex, int sum) {
        System.out.println(endIndex + " " + sum);
        if (memoTag[endIndex][sum]) {
            return memo[endIndex][sum];
        }
        if (endIndex == 0) {
            memo[endIndex][sum] = sum == nums[endIndex];
            memoTag[endIndex][sum] = true;
            return memo[endIndex][sum];
        }
        if (nums[endIndex] > sum) {
            memo[endIndex][sum] = dfs(endIndex - 1, sum);
            memoTag[endIndex][sum] = true;
            return memo[endIndex][sum];
        }
        if (nums[endIndex] == sum) {
            memo[endIndex][sum] = true;
            memoTag[endIndex][sum] = true;
            return memo[endIndex][sum];
        }
        memo[endIndex][sum] = dfs(endIndex - 1, sum - nums[endIndex]) || dfs(endIndex - 1, sum);
        memoTag[endIndex][sum] = true;
        return memo[endIndex][sum];
    }
}
