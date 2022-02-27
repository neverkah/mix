package com.algorithm.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            while (bIndex < cIndex) {
                if (bIndex > aIndex + 1 && nums[bIndex] == nums[bIndex - 1]) {
                    bIndex++;
                    continue;
                }
                if (nums[aIndex] + nums[bIndex] + nums[cIndex] > 0) {
                    cIndex--;
                } else if (nums[aIndex] + nums[bIndex] + nums[cIndex] == 0) {
                    res.add(Arrays.asList(nums[aIndex], nums[bIndex], nums[cIndex]));
                    bIndex++;
                    cIndex--;
                } else {
                    bIndex++;
                }
            }
            aIndex++;
        }
        return res;
    }
}