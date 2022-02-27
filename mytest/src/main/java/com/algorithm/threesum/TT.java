package com.algorithm.threesum;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TT {
    public static int getNearMoreIndex(int[] nums, int key) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int[] nums = new int[10];
        while (true) {
            for (int i = 0; i < 10; i++) {
                nums[i] = r.nextInt(10) + 1;
            }
            int key = r.nextInt(20) + 1;
            Arrays.sort(nums);
//            if (binarySearch(nums, key) != getNearMoreIndex(nums, key)) {
//                System.err.println("err");
//                for (int i = 0; i < nums.length; i++) {
//                    System.out.print(nums[i] + " ");
//                }
//                System.out.println("key :" + key);
//                break;
//            }
        }
    }
    @Test
    public  void test6(){
        int[] nums = new int[]{1,2,3,6,9,12,17,20,26};
        System.out.println(new Solution2().binarySearch(nums, 0, nums.length - 1, 17));
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 2, 3, 3, 4, 4, 4, 6, 8};
        int key = 3;
//        System.out.println(binarySearch(nums, 3));
        System.out.println(getNearMoreIndex(nums, key));
    }

    @Test
    public void test1() {
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
//        int[] nums = new int[]{-1,0,1,2,-1,-4};
        int[] nums = new int[]{1, 2, -2, -1};
        for (List<Integer> integerList : new Solution().threeSum(nums)) {
            System.out.println(integerList);
        }
    }

    @Test
    public void test2() {
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
//        int[] nums = new int[]{-1,0,1,2,-1,-4};
//        int[] nums = new int[]{1, 2, -2, -1};
//        int[] nums = new int[]{-2, 0, 1, 1, 2};
        for (List<Integer> integerList : new com.algorithm.threesum2.Solution().threeSum(nums)) {
            System.out.println(integerList);
        }
    }

    @Test
    public void test3() {
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
//        int[] nums = new int[]{-1,0,1,2,-1,-4};
        int[] nums = new int[10000];
        nums[0] = -4;
        nums[1] = 1;
        nums[2] = 3;
        Random r = new Random();
        for (int i = 3; i < nums.length; i++) {
            nums[i] = r.nextInt(100) + 10;
        }
        Solution2 solution2 = new Solution2();
        Solution solution = new Solution();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            solution2.threeSum(nums);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            solution.threeSum(nums);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
