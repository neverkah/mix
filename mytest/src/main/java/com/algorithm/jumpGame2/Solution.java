package com.algorithm.jumpGame2;

import java.util.Arrays;

class Solution {
    int[] nums;
    // memo[i]表示是否能从第i个位置跳到最后一个位置
    int[] memo;

    public boolean canJump(int[] nums) {
        this.nums = nums;
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return canJump(0);
    }

    public boolean canJump(int idx) {
        if (memo[idx] > -1) {
            return memo[idx] == 1;
        }
        if (nums.length - 1 - idx <= nums[idx]) {
            return true;
        }
        if (nums[idx] == 0) {
            memo[idx] = 0;
            return false;
        }
        for (int step = nums[idx]; step > 0; step--) {
            if (canJump(idx + step)) {
                memo[idx] = 1;
                return true;
            }
        }
        memo[idx] = 0;
        return false;
    }
}