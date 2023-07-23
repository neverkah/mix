package com.algorithm.containsDuplicateIii;

import com.algorithm.containsDuplicateIii.m3.Solution;

import java.util.Random;

public class T {

    public static void main(String[] args) {


//        int[] nums = {1, 2, 3, 1};
//        int k = 3, t = 0;
//        System.out.println(new Solution().containsNearbyAlmostDuplicate(nums, k, t));

        System.out.println(Integer.MAX_VALUE);

        Solution solution3 = new Solution();

        com.algorithm.containsDuplicateIii.Solution solution = new com.algorithm.containsDuplicateIii.Solution();
        int numLength = 6;

        while (true) {


            Random random = new Random();
            int[] nums = new int[numLength];
            for (int i = 0; i < numLength; i++) {
                nums[i] = random.nextInt(16);
                int pn = random.nextInt(2);
                nums[i] = pn == 0 ? nums[i] * (-1) : nums[i];
            }

            int indexDiff = random.nextInt(5) + 1;
            int valueDiff = random.nextInt(16);
            if (solution3.containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff) != solution.containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff)) {
                System.out.println("nums ");
                for (int num : nums) {
                    System.out.print(num);
                }
                System.out.println();
                System.out.println(indexDiff);
                System.out.println(valueDiff);
                break;
            }

        }


    }
}
