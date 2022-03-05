package com.algorithm.maximumSumOfTwoNonOverlappingSubarrays;

import org.junit.Test;

public class T {

    public static void main(String[] args) {

        int[] nums = {3, 8, 1, 3, 2, 1, 8, 9, 0};
        int firstLen = 3, secondLen = 2;

        System.out.println(new Solution().maxSumTwoNoOverlap(nums, firstLen, secondLen));
    }

    @Test
    public void test1() {

        int[] nums = {2, 1, 5, 6, 0, 9, 5, 0, 3, 8};
        int firstLen = 4, secondLen = 3;

        System.out.println(new Solution().maxSumTwoNoOverlap(nums, firstLen, secondLen));
    }
}
