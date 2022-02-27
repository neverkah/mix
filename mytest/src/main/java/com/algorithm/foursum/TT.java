package com.algorithm.foursum;

import org.junit.Test;

import java.util.List;

public class TT {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;

        Solution2 solution2 = new Solution2();
        for (List<Integer> integerList : solution2.fourSum(nums, target)) {
            System.out.println(integerList);
        }
    }

    @Test
    public void test1() {
        int[] nums = new int[]{1000000000, 1000000000, 1000000000, 1000000000, 0, 0, 1000000000};
        int target = 2000000000;

        Solution solution = new Solution();
        for (List<Integer> integerList : solution.fourSum(nums, target)) {
            System.out.println(integerList);
        }
    }
}
