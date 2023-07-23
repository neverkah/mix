package com.algorithm.containsDuplicateIii.m3;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length && j <= i + indexDiff; j++) {
                if (Math.abs(nums[j] - nums[i]) <= valueDiff) {
                    return true;
                }
            }
        }
        return false;
    }
}
