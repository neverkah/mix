package com.algorithm.targetSum;

import org.junit.Test;

import java.util.Random;

public class T {
    public static void main(String[] args) {
        int[] nums = {0,5,5};
        int target = -10;
        System.out.println(new Solution().findTargetSumWays(nums, target));
        System.out.println(new Solution().findTargetSumWays2(nums, target));
    }

    @Test
    public void test1() {
        Random r = new Random();
        int N = 3;
        Solution s = new Solution();
        while (true) {
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = r.nextInt(11);
            }
            int target = r.nextInt(21) - 10;
            if (s.findTargetSumWays(nums, target) != Solution.findTargetSumWays2(nums, target)) {
                for (int num : nums) {
                    System.out.println(num);
                }
                System.out.println();
                System.out.println(target);
                break;
            }
        }
    }
}
