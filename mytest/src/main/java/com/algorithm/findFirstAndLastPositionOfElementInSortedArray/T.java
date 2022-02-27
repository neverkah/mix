package com.algorithm.findFirstAndLastPositionOfElementInSortedArray;

public class T {

    public static void main(String[] args) {
        int[] nums = new  int[]{};
        int target = 0;

        for (int i : new Solution().searchRange(nums, target)) {
            System.out.println(i);
        }
    }
}
