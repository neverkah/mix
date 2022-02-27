package com.algorithm.threesum2;

import java.util.*;

/**
 * 哈希法
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int aIndex = 0, end = nums.length - 1;
        while (aIndex <= end - 2) {
            if (aIndex > 0 && nums[aIndex] == nums[aIndex - 1]) {
                aIndex++;
                continue;
            }
            if (nums[aIndex] + nums[end - 1] + nums[end] < 0) {
                aIndex++;
                continue;
            }
            if (nums[aIndex] + nums[aIndex + 1] + nums[end] > 0) {
                end--;
                continue;
            }
            // 假定a<=b<=c
            // a=nums[begin] ，取得所有nums[i]+b+c=0的情况，然后将nums[begin]从计算范围里去除
            int bIndex = aIndex + 1; // b = nums[tbegin]
            int cIndex = end;//c 取值的最右坐标
            Map<Integer, Integer> map = new HashMap<>();
            boolean lastMatched = false;
            Integer secondIndex = null;
            for (int i = bIndex; i <= cIndex; i++) {
                if (secondIndex != null && secondIndex == bIndex) {
                    break;
                }
                if (lastMatched && nums[i] == nums[i - 1]) {
                    continue;
                }
                // 0-nums[aIndex]
                secondIndex = map.get(-nums[aIndex] - nums[i]);
                if (null != secondIndex) {
                    res.add(Arrays.asList(nums[aIndex], -nums[aIndex] - nums[i], nums[i]));
                    lastMatched = true;
                } else {
                    lastMatched = false;
                }
                map.put(nums[i], i);
            }
            aIndex++;
        }
        return res;
    }
}