package com.algorithm.coinChange2;

public class T {

    public static void main(String[] args) {
        int[] coins = {7, 2, 9};
        int amount = 23;

        System.out.println(new Solution().change(amount, coins));

    }
}
