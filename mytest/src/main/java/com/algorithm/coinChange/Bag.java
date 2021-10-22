package com.algorithm.coinChange;

import java.util.Arrays;

/*
leetcode 322 coin change
*/
public class Bag {
    //    给定无限个不同重量的金属球和一个总重量，求可以凑成总重量所需的最少球的个数， 如果凑不成返回-1,例如：
//    输入：ball_weights = [1, 2 , 5],  amount=11
//    输出：3          11=5+5+1
    /*
    递归实现
     */
    public static int process(int[] bw, int amout, int i) {
        if (i == 0) {
            if (amout % bw[0] == 0) {
                return amout / bw[0];
            } else {
                return -1;
            }
        }
        int result = -1;
        for (int t = 0; t <= amout / bw[i]; t++) {
            int prev = process(bw, amout - bw[i] * t, i - 1);
            if (-1 != prev) {
                if (-1 == result) {
                    result = prev + t;
                } else {
                    result = Math.min(result, prev + t);
                }
            }
        }
        return result;
    }

    /*
    动态规划实现
     */
    public static int process(int[] bw, int amount) {
        Arrays.sort(bw);
        int[][] result = new int[bw.length][amount + 1];
        for (int j = 0; j < amount + 1; j++) {
            if (j % bw[0] == 0) {
                result[0][j] = j / bw[0];
            } else {
                result[0][j] = -1;
            }
        }
        for (int i = 1; i < bw.length; i++) {
            for (int j = 0; j < amount + 1; j++) {
                result[i][j] = -1;
            }
        }
        for (int i = 1; i < bw.length; i++) {
            for (int j = amount / bw[i]; j >= 0; j--) {
                for (int k = bw[i] * j; k < amount + 1; k++) {
                    if (-1 != result[i - 1][k - bw[i] * j]) {
                        if (-1 == result[i][k]) {
                            result[i][k] = result[i - 1][k - bw[i] * j] + j;
                        } else {
                            result[i][k] = Math.min(result[i][k], result[i - 1][k - bw[i] * j] + j);
                        }
                    }
                }
            }
        }
        return result[bw.length - 1][amount];
    }

    public static void main(String[] args) {
//        int[] bw = {1, 2, 5};
//
//        int amout = 11;
        int[] bw = {186, 419, 83, 408};
        int amout = 6249;
        Arrays.sort(bw);
        int result = process(bw, amout, bw.length - 1);
        int dpResult = process(bw, amout);
        System.out.println(result);
        System.out.println(dpResult);
    }
}
