package com.algorithm.findFirstAndLastPositionOfElementInSortedArray.m2;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = binarySearch(nums, 0, nums.length - 1, target, true);
        res[1] = binarySearch(nums, 0, nums.length - 1, target, false);
        return res;
    }

    public int binarySearch(int[] nums, int start, int end, int key, boolean toLeft) {
        int mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] < key) {
                start = mid + 1;
            } else if (nums[mid] > key) {
                end = mid - 1;
            } else {
                if (toLeft) {
                    if (mid - 1 >= 0 && nums[mid - 1] == key) {
                        end = mid - 1;
                    } else {
                        return mid;
                    }
                } else {
                    if (mid + 1 <= end && nums[mid + 1] == key) {
                        start = mid + 1;
                    } else {
                        return mid;
                    }
                }
            }
        }
        return -1;
    }
}