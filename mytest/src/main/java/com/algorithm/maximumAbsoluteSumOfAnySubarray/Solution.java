package com.algorithm.maximumAbsoluteSumOfAnySubarray;

class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = 0, min = 0;
        int res = 0;
        for (int num : nums) {
            max = Math.max(max + num, num);
            min = Math.min(min + num, num);
            res = Math.max(res, maxAbsolute(max, min));
        }
        return res;
    }

    private int maxAbsolute(int a, int b) {
        return Math.max(Math.abs(a), Math.abs(b));
    }
}