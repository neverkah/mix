package com.algorithm.containsDuplicateIii;

import java.util.TreeSet;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int right = 1;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int left = 0; left < nums.length - 1; left++) {
            for (; right <= left + k && right < nums.length; right++) {
                if (treeSet.contains(nums[right])) {
                    return true;
                }
                treeSet.add(nums[right]);
            }
            int leftV = nums[left];
            if (match(treeSet.floor(leftV), leftV, t)) {
                return true;
            }
            if (match(treeSet.ceiling(leftV), leftV, t)) {
                return true;
            }
            treeSet.remove(nums[left + 1]);
        }
        return false;
    }

    public boolean match(Integer target, int leftV, int t) {
        return target != null && Math.abs(target - leftV) <= t;
    }
}