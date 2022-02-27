package com.algorithm.twoSum2;

public class TT {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3};
        int target = 6;
        Solution solution = new Solution();
        for (int i : solution.twoSum(nums, target)) {
            System.out.println(i);
        }
    }
}
