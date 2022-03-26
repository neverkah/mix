package com.algorithm.partitionEqualSubsetSum;

import org.junit.Test;

import java.util.Random;

public class SolutionTest {

    public static void main(String[] args) {
//        int[] nums = new int[]{8, 11, 15, 18, 18, 20};
        Solution solution = new Solution();
        Solution6 solution6 = new Solution6();


        for (int j = 1; j < 100000; j++) {
            int[] nums = new int[20];
            Random r = new Random();

            for (int i = 0; i < 6; i++) {
                nums[i] = r.nextInt(100) + 1;
            }

            if (solution.canPartition(nums) != solution6.canPartition(nums)) {
                System.err.println(" xxxx ");
                break;
            }

        }
    }

    @Test
    public void test() {
        long start = System.currentTimeMillis();
        int[] nums = new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97};
        Solution4 solution = new Solution4();
        solution.canPartition(nums);
        long end = System.currentTimeMillis();

        System.out.println( start-end);
    }
}
