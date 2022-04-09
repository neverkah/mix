package com.algorithm.subarraySumEqualsK;

class Solution2 {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i] = (i > 0 ? sum[i - 1] : 0) + nums[i];
            if (sum[i] == k) {
                res++;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (sum[i] - sum[j] == k) {
                    res++;
                }
            }
        }
        return res;
    }
}