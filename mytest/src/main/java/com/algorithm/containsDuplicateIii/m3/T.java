package com.algorithm.containsDuplicateIii.m3;


public class T {

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 2};
        Solution solution = new Solution();
        boolean b = solution.containsNearbyAlmostDuplicate(nums, 1, 2);
        System.out.println(b);
    }
}
