package com.algorithm.closestSubsequenceSum.m3;

public class T {

    public static void main(String[] args) {
        int[] nums = {5, -7, 3, 5};
        int goal = 6;

        System.out.println(new Solution().minAbsDifference(nums, goal));
    }
}
