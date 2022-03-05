package com.algorithm.maximumAlternatingSubsequenceSum.m2;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int top = 0;
        int down = 0;
        boolean lookUp = true;
        long res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (lookUp && nums[i + 1] < nums[i]) {
                top = nums[i];
                lookUp = false;
            }
            if (!lookUp && nums[i + 1] > nums[i]) {
                down = nums[i];
                res += top - down;
                lookUp = true;
            }
        }
        if (lookUp) {
            res += nums[nums.length - 1];
        } else {
            res += top;
        }
        return res;
    }

    public long maxAlternatingSum2(int[] nums) {
        long ans = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                ans += nums[i] - nums[i - 1];
            }
        }
        return ans;
    }
}