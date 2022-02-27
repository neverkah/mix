package com.algorithm.findFirstAndLastPositionOfElementInSortedArray.m2;



import org.junit.Test;

import java.util.Arrays;

public class T {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[1024];
        Arrays.fill(nums, 8);
        nums[0] = 2;
        nums[1] = 3;
        nums[2] = 4;
        int target = 8;
        System.out.println(solution.binarySearch(nums, 0, nums.length - 1, target, false));

    }
    @Test
   public    void test1(){
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        for (int i : new Solution().searchRange(nums, target)) {
            System.out.println(i);
        }
    }
}
