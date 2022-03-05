package com.algorithm.findTwoNonOverlappingSubArraysEachWithTargetSum.m2;

public class T {

    public static void main(String[] args) {
        int[] arr = {3,1,1,1,5,1,2,1};

        int target = 3;

        System.out.println(new Solution().minSumOfLengths(arr, target));
    }
}
