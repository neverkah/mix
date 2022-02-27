package com.algorithm.twoSum;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> set = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.get(target - nums[i]) != null) {
                res[0] = set.get(target - nums[i]);
                res[1] = i;
                break;
            }
            set.put(nums[i], i);
        }
        return res;
    }
}