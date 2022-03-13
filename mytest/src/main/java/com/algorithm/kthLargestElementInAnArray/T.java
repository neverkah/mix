package com.algorithm.kthLargestElementInAnArray;

public class T {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;

        System.out.println(new Solution().findKthLargest(nums, k));
    }
}
