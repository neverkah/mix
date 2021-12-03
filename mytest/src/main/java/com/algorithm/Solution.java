package com.algorithm;

public class Solution {
    public static void main(String[] args) {
        int[] bw = {186, 419, 83, 408};
        int amout = 6249;

//                int[] bw = {1, 2, 5};
//
//        int amout = 11;


        System.out.println(new Solution().process(bw, amout));

    }

    public int coinChange1(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount);
    }

    private int coinChange(int[] coins, int rem) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }

        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

    private int process(int[] coins, int amount) {
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

