package com.algorithm.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int aIndex = 0, end = nums.length - 1;
        while (aIndex <= end - 3) {
            if (aIndex > 0 && nums[aIndex] == nums[aIndex - 1]) {
                aIndex++;
                continue;
            }
            if (nums[aIndex] < target - nums[end - 2] - nums[end - 1] - nums[end]) {
                aIndex++;
                continue;
            }
            if (nums[end] > target - nums[aIndex] - nums[aIndex + 1] - nums[aIndex + 2]) {
                end--;
                continue;
            }
            int bIndex = aIndex + 1;
            int bEnd = end;
            while (bIndex <= bEnd) {
                if (bIndex > aIndex + 1 && nums[bIndex] == nums[bIndex - 1]) {
                    bIndex++;
                    continue;
                }
                if (nums[aIndex] < target - nums[bEnd - 2] - nums[bEnd - 1] - nums[bEnd]) {
                    aIndex++;
                    continue;
                }
                if (nums[bEnd] > target - nums[aIndex] - nums[aIndex + 1] - nums[aIndex + 2]) {
                    bEnd--;
                    continue;
                }
                int cIndex = bIndex + 1;
                int dIndex = bEnd;
                while (cIndex < dIndex) {
                    if (cIndex > bIndex + 1 && nums[cIndex] == nums[cIndex - 1]) {
                        cIndex++;
                        continue;
                    }
                    if (nums[dIndex] > target - nums[aIndex] - nums[bIndex] - nums[cIndex]) {
                        dIndex--;
                    } else if (nums[dIndex] == target - nums[aIndex] - nums[bIndex] - nums[cIndex]) {
                        res.add(Arrays.asList(nums[aIndex], +nums[bIndex], nums[cIndex], nums[dIndex]));
                        cIndex++;
                        dIndex--;
                    } else {
                        cIndex++;
                    }
                }
                bIndex++;
            }
            aIndex++;
        }
        return res;
    }
}