package com.algorithm.jumpGame2;

class Solution {
    int[] nums;
    // memo[i]表示是否能从第i个位置跳到最后一个位置
    int[] memo;

    int Y = 1, N = -1, EMPTY = 0;

    public boolean canJump(int[] nums) {
        this.nums = nums;
        memo = new int[nums.length];
        return canJump(0);
    }

    public boolean canJump(int idx) {
        if (memo[idx] != EMPTY) {
            return memo[idx] == Y;
        }
        if (nums.length - 1 - idx <= nums[idx]) {
            return true;
        }
        if (nums[idx] == 0) {
            memo[idx] = N;
            return false;
        }
        for (int step = nums[idx]; step > 0; step--) {
            if (canJump(idx + step)) {
                memo[idx] = Y;
                return true;
            }
        }
        memo[idx] = N;
        return false;
    }
}