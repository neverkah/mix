package com.algorithm.threeSumClosest;

import java.util.Arrays;

class Solution2 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int N = nums.length;
        int sumClosest = 0;
        int disClosest = Integer.MAX_VALUE;
        for (int i = 1; i <= N - 2; i++) {
            if (i >= 2 && nums[i - 1] == nums[i - 2]) {
                continue;
            }
            int left = i, right = N - 1;
            while (left < right) {
                int sum = nums[i - 1] + nums[left] + nums[right];
                if (sum > target) {
                    if (sum - target < disClosest) {
                        disClosest = sum - target;
                        sumClosest = sum;
                    }
                    right--;
                } else if (sum == target) {
                    return target;
                } else {
                    if (target - sum < disClosest) {
                        disClosest = target - sum;
                        sumClosest = sum;
                    }
                    left++;
                }
            }
        }
        return sumClosest;
    }
}