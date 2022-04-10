package com.algorithm.closestSubsequenceSum.m2;

import org.junit.Test;

public class T {

    public static void main(String[] args) {
        int[] nums = {-7074297, 3076735, -5846354, 5008659, -126683, 7039557, 6708811, 3189666, -6102417, 6078975, -6448946, -4995910, 2964239, -3248847, -4392269, 7473223, -1356059, 3978911, 8009187, -316441, 6524770, 8280309, -2798383, 1310839, 6306594, -6548611, -9712711, 1639314};
//        System.out.println(nums.length);
        int goal = 493409180;
        System.out.println(new Solution().minAbsDifference(nums, goal));
    }

    @Test
    public void test() {

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(nums.length);
        int goal = -7;
        System.out.println(new Solution().minAbsDifference(nums, goal));
    }


}
