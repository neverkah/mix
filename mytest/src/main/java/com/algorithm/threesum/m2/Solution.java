package com.algorithm.threesum.m2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        int N = nums.length;
        for (int i = 0; i < N - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = N - 1;
            while (left < right) {
                if (left >= i + 2 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}