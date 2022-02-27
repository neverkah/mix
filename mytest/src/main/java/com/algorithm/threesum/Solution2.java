package com.algorithm.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {

    /**
     * 若存在与key相等的数，则返回相等数的下标
     * 否则返回 >key 的最小的数的下标
     * 若所有数都小于key，则返回-1
     *
     * @param nums
     * @param start
     * @param end
     * @param key
     * @return
     */
    public int binarySearch(int[] nums, int start, int end, int key) {
        if (key > nums[end]) {
            return -1;
        }

        int mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
//        if (start > end) {
//            return -1;
//        }
        return start;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int aIndex = 0, end = nums.length - 1;
        while (aIndex <= end - 2) {
            if (aIndex > 0 && nums[aIndex] == nums[aIndex - 1]) {
                aIndex++;
                continue;
            }

//            if (nums[aIndex] > 0 || nums[end] < 0) {
//                return res;
//            }
//            if (nums[aIndex] < 0 && nums[aIndex] + nums[end] + nums[end - 1] < 0) {
//                aIndex++;
//                continue;
//            }
//            if (nums[end] > 0 && nums[aIndex] + nums[aIndex + 1] + nums[end] > 0) {
//                end--;
//                continue;
//            }
            // 假定a<=b<=c
            // a=nums[begin] ，取得所有nums[i]+b+c=0的情况，然后将nums[begin]从计算范围里去除
            int bIndex = aIndex + 1; // b = nums[tbegin]
            int cIndex = end;//c 取值坐标
            while (bIndex < cIndex) {
                if (bIndex > aIndex + 1 && nums[bIndex] == nums[bIndex - 1]) {
                    bIndex++;
                    continue;
                }
                int foundCIndex = binarySearch(nums, bIndex + 1, cIndex, -nums[aIndex] - nums[bIndex]);
                if (foundCIndex != -1) {
                    if (nums[foundCIndex] == -nums[aIndex] - nums[bIndex]) {
                        res.add(Arrays.asList(nums[aIndex], nums[bIndex], nums[foundCIndex]));
                    }
                    bIndex++;
                    cIndex = foundCIndex - 1;
                } else {
                    bIndex++;
                }
            }
            aIndex++;
        }
        return res;
    }
}