package com.algorithm.twosum3;

public class TT {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 4, 3, 0};
        int target = 0;

        for (int i : new Solution().twoSum(nums, target)) {
            System.out.println(i);
        }
    }
}
