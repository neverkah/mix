package com.algorithm.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end - 3) {
            if (begin > 0 && nums[begin] == nums[begin - 1]) {
                begin++;
                continue;
            }
            if (nums[begin] < target - nums[end - 2] - nums[end - 1] - nums[end]) {
                begin++;
                continue;
            }
            if (nums[end] > target - nums[begin] - nums[begin + 1] - nums[begin + 2]) {
                end--;
                continue;
            }
            threeSum(nums, begin + 1, end, target - nums[begin], begin, res);
            begin++;
        }
        return res;
    }

    public void threeSum(int[] nums, int begin, int end, int target, int firstIndex, List<List<Integer>> res) {
        int aIndex = begin;
        while (aIndex <= end - 2) {
            if (aIndex > begin && nums[aIndex] == nums[aIndex - 1]) {
                aIndex++;
                continue;
            }
            if (nums[aIndex] < target - nums[end - 1] - nums[end]) {
                aIndex++;
                continue;
            }
            if (nums[end] > target - nums[aIndex] - nums[aIndex + 1]) {
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
                if (nums[cIndex] > target - nums[aIndex] - nums[bIndex]) {
                    cIndex--;
                } else if (nums[cIndex] == target - nums[aIndex] - nums[bIndex]) {
                    res.add(Arrays.asList(nums[firstIndex], nums[aIndex], nums[bIndex], nums[cIndex]));
                    bIndex++;
                    cIndex--;
                } else {
                    bIndex++;
                }
            }
            aIndex++;
        }
    }
}