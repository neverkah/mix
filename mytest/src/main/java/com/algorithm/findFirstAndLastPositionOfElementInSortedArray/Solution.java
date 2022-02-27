package com.algorithm.findFirstAndLastPositionOfElementInSortedArray;

import java.util.Arrays;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public int[] binarySearch(int[] nums, int start, int end, int key) {
        int[] res = new int[2];
        int mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == key) {
                int l = mid - 1;
                while (l >= 0) {
                    if (nums[l] != key) {
                        break;
                    }
                    l--;
                }
                int r = mid + 1;
                while (r <= end) {
                    if (nums[r] != key) {
                        break;
                    }
                    r++;
                }
                res[0] = l + 1;
                res[1] = r - 1;
                return res;
            } else if (nums[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        Arrays.fill(res, -1);
        return res;
    }
}