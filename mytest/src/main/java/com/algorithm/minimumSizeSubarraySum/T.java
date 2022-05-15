package com.algorithm.minimumSizeSubarraySum;

public class T {

    public static void main(String[] args) {
        int[] nums = {1,4,4};
        int target = 4;
        System.out.println(new Solution().minSubArrayLen(target, nums));
    }
}
