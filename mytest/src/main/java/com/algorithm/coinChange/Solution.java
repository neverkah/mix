package com.algorithm.coinChange;
/*
leetcode 322 coin change
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] result = new int[amount + 1];
        result[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int res = i - coin < 0 ? -1 : result[i - coin];
                if (res >= 0) {
                    min = Math.min(min, 1 + res);
                }
            }
            result[i] = (min == Integer.MAX_VALUE) ? -1 : min;
        }
        return result[amount];
    }
}
