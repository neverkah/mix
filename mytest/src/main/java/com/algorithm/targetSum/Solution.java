package com.algorithm.targetSum;

import java.util.Arrays;

class Solution {
    public static int findTargetSumWays2(int[] nums, int s) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 绝对值范围超过了sum的绝对值范围则无法得到
        if (Math.abs(s) > Math.abs(sum)) return 0;
        int len = nums.length;
        // - 0 +
        int t = sum * 2 + 1;
        int[][] dp = new int[len][t];
        // 初始化
        if (nums[0] == 0) {
            dp[0][sum] = 2;
        } else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < t; j++) {
                // 边界
                int l = Math.max((j - nums[i]), 0);
                int r = (j + nums[i]) < t ? j + nums[i] : 0;
                dp[i][j] = dp[i - 1][l] + dp[i - 1][r];
            }
        }
        return dp[len - 1][sum + s];
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int half = n / 2;
        int ls = half, rs = n - half;
        int[] lsum = new int[1 << ls];
        for (int i = 0; i < ls; i++) {
            lsum[0] += -nums[i];
        }
        for (int i = 1; i < lsum.length; i++) {
            for (int j = 0; j < ls; j++) {
                if ((i & (1 << j)) == 0) continue;
                lsum[i] = lsum[i - (1 << j)] + 2 * nums[j];
                break;
            }
        }
        int[] rsum = new int[1 << rs];
        for (int i = 0; i < rs; i++) {
            rsum[0] += -nums[ls + i];
        }
        for (int i = 1; i < rsum.length; i++) {
            for (int j = 0; j < rs; j++) {
                if ((i & (1 << j)) == 0) continue;
                rsum[i] = rsum[i - (1 << j)] + 2 * nums[ls + j];
                break;
            }
        }
        Arrays.sort(lsum);
        Arrays.sort(rsum);
        int res = 0;
        int j = rsum.length - 1;
        int t = 0;
        for (int i = 0; i < lsum.length; i++) {
            if (i > 0) {
                if (lsum[i] == lsum[i - 1]) {
                    res += t;
                    continue;
                } else {
                    t = 0;
                }
            }
            while (j >= 0) {
                int s = lsum[i] + rsum[j];
                if (s > target) {
                    j--;
                } else if (s == target) {
                    j--;
                    t++;
                    res++;
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public int findTargetSumWays3(int[] nums, int target) {
        int res = 0;
        int N = nums.length;
        int[] sumArr = new int[1 << N];
        for (int i = 0; i < N; i++) {
            sumArr[0] += -nums[i];
        }
        if (sumArr[0] == target) {
            res++;
        }
        for (int i = 1; i < sumArr.length; i++) {
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) == 0) continue;
                sumArr[i] = sumArr[i - (1 << j)] + 2 * nums[j];
                if (sumArr[i] == target) {
                    res++;
                }
                break;
            }
        }
        return res;
    }



}