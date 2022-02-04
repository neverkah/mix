package com.algorithm.jumpGame3;

class Solution {
    public boolean canJump(int[] nums) {
        int canReachMaxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= canReachMaxIndex) {
                canReachMaxIndex = Math.max(canReachMaxIndex, i + nums[i]);
                if (canReachMaxIndex >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}