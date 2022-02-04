package com.algorithm.jumpGame;

import java.util.Arrays;

class Solution {
    int[] nums;
    // memo[i]表示从第一个位置能否跳到第i个位置
    int[] memo;

    public boolean canJump(int[] nums) {
        this.nums = nums;
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return canJump(nums.length - 1);
    }

    public boolean canJump(int idx) {
        if (memo[idx] > -1) {
            return memo[idx] == 1;
        }
        if (idx == 0) {
            memo[idx] = 1;
            return true;
        }
        for (int i = idx - 1; i >= 0; i--) {
            if (canJump(i) && idx - i <= nums[i]) {
                memo[idx] = 1;
                return true;
            }
        }
        memo[idx] = 0;
        return false;
    }
}