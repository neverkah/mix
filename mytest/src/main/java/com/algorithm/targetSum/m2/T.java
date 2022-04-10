package com.algorithm.targetSum.m2;

import org.junit.Test;

import java.util.Random;

public class T {
    public static void main(String[] args) {
        int[] nums = {201, 66, 72, 784, 192, 243, 606, 647, 89, 816, 559, 448, 940, 349, 898, 68, 266, 837, 267, 609};
        int target = 871;
        System.out.println(new Solution().findTargetSumWays(nums, target));
    }

    @Test
    public void test1() {
        Random r = new Random();
        int N = 20;
        Solution s = new Solution();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = r.nextInt(1001);
        }
        int target = r.nextInt(2001) - 1000;
        try {
            System.out.println(s.findTargetSumWays(nums, target));
        } catch (Exception e) {
            e.printStackTrace();
            for (int num : nums) {
                System.out.println(num);
            }
            System.out.println();
            System.out.println(target);
        }
    }
}
