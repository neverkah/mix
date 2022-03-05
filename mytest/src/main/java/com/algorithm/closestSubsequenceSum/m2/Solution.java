package com.algorithm.closestSubsequenceSum.m2;

import java.util.Arrays;

class Solution {
    int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int half = n / 2;
        int ls = half, rs = n - half;
        int[] lsum = new int[1 << ls];
        for (int i = 1; i < lsum.length; i++) {
            for (int j = 0; j < ls; j++) {
                if ((i & (1 << j)) == 0) continue;
                lsum[i] = lsum[i - (1 << j)] + nums[j];
                break;
            }
        }
        int[] rsum = new int[1 << rs];
        for (int i = 1; i < rsum.length; i++) {
            for (int j = 0; j < rs; j++) {
                if ((i & (1 << j)) == 0) continue;
                rsum[i] = rsum[i - (1 << j)] + nums[ls + j];
                break;
            }
        }
        Arrays.sort(lsum);
        Arrays.sort(rsum);
        int ret = Integer.MAX_VALUE;
        for (int x : lsum) {
            ret = Math.min(ret, Math.abs(goal - x));
        }
        for (int x : rsum) {
            ret = Math.min(ret, Math.abs(goal - x));
        }
        int i = 0, j = rsum.length - 1;
        while (i < lsum.length && j >= 0) {
            int s = lsum[i] + rsum[j];
            ret = Math.min(ret, Math.abs(goal - s));
            if (s > goal) {
                j--;
            } else {
                i++;
            }
        }
        return ret;
    }
}
