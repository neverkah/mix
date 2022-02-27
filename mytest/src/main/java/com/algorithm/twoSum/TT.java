package com.algorithm.twoSum;

public class TT {

    public static void main(String[] args) {
        int[] nums= new int[]{3,3};
        int target = 6;
        for (int i : new Solution().twoSum(nums, target)) {
            System.out.println(i);
        }

    }
}
