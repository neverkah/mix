package com.algorithm.kthLargestElementInAnArray.m2;

public class T {

    public static void main(String[] args) {

        int k = 2;

        while (true) {
            int[] nums = {3, 2, 1, 5, 6, 4};
            int res = new Solution().findKthLargest(nums, k);
            if (res == 0) {
                System.out.println("error");
                break;
            }
        }


    }
}
