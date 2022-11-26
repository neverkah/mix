package com.algorithm.threeSumClosest;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int N = nums.length;
        int closest = Integer.MAX_VALUE;
        int targetSum = 0;
        for (int i = 1; i <= N - 2; i++) {
            if (i >= 2 && nums[i - 1] == nums[i - 2]) {
                continue;
            }
            int left = i, right = N - 1;
            while (left < right) {
                while (right > left && nums[i - 1] + nums[left] + nums[right] > target) {
                    int sum = nums[i - 1] + nums[left] + nums[right];
                    if (Math.abs(sum - target) < closest) {
                        closest = Math.abs(sum - target);
                        targetSum = sum;
                    }
                    right--;
                }
                if (left >= right) {
                    break;
                }
                int sum = nums[i - 1] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < closest) {
                    closest = Math.abs(sum - target);
                    targetSum = sum;
                }
                left++;
            }
        }
        return targetSum;
    }
}