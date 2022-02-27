package com.algorithm.findFirstAndLastPositionOfElementInSortedArray.m3;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = binarySearch(nums, target, true);
        res[1] = binarySearch(nums, target, false);
        return res;
    }

    public int binarySearch(int[] nums, int key, boolean toLeft) {
        int start = 0, end = nums.length - 1;
        int res = -1;
        int mid;
        while (start <= end) {
            if (nums[end] < key || nums[start] > key) {
                return res;
            }
            mid = (start + end) / 2;
            if (nums[mid] < key) {
                start = mid + 1;
            } else if (nums[mid] > key) {
                end = mid - 1;
            } else if (toLeft) {
                res = mid;
                end = mid - 1;
            } else {
                res = mid;
                start = mid + 1;
            }
        }
        return res;
    }
}