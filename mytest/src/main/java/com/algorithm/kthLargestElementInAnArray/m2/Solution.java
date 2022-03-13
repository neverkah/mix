package com.algorithm.kthLargestElementInAnArray.m2;

import java.util.Random;

class Solution {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1;
        k = nums.length - k;
        while (start <= end) {
            if (start == end) {
                return nums[end];
            }
            int cut = random.nextInt(end - start + 1) + start;
            swap(nums, cut, end);
            int largerNumIdx = start;
            for (int i = start; i <= end - 1; i++) {
                if (nums[i] <= nums[end]) {
                    swap(nums, i, largerNumIdx++);
                }
            }
            swap(nums, largerNumIdx, end);
            if (largerNumIdx == k) {
                return nums[largerNumIdx];
            } else if (largerNumIdx > k) {
                end = largerNumIdx - 1;
            } else {
                start = largerNumIdx + 1;
            }
        }
        return 0;
    }

    public void swap(int[] a, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
