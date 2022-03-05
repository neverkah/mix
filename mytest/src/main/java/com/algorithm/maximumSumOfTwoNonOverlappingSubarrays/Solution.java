package com.algorithm.maximumSumOfTwoNonOverlappingSubarrays;

class Solution {
    int[] sum;
    int[] nums;

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        this.nums = nums;
        this.sum = new int[nums.length];
        // dpFisrt[i] [i,nums.length-1]范围内长度为firstLen子数组和的最大值
        int[] dpFisrt = new int[nums.length];
        int[] dpSecond = new int[nums.length];
        int maxRes = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i] = (i == 0 ? 0 : sum[i - 1]) + nums[i];
        }
        for (int i = nums.length - firstLen; i >= 0; i--) {
            dpFisrt[i] = Math.max(i == nums.length - firstLen ? Integer.MIN_VALUE : dpFisrt[i + 1], subSum(i, firstLen));
        }
        for (int i = nums.length - secondLen; i >= 0; i--) {
            dpSecond[i] = Math.max(i == nums.length - secondLen ? Integer.MIN_VALUE : dpSecond[i + 1], subSum(i, secondLen));
        }
        for (int i = 0; i <= nums.length - firstLen && i + firstLen <= nums.length - secondLen; i++) {
            maxRes = Math.max(maxRes, subSum(i, firstLen) + dpSecond[i + firstLen]);
        }
        for (int i = 0; i <= nums.length - secondLen && i + secondLen <= nums.length - firstLen; i++) {
            maxRes = Math.max(maxRes, subSum(i, secondLen) + dpFisrt[i + secondLen]);
        }
        return maxRes;
    }

    private int subSum(int i, int len) {
        if (i == 0) {
            return sum[len - 1];
        }
        return sum[i + len - 1] - sum[i - 1];
    }
}