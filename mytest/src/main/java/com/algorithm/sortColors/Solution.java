package com.algorithm.sortColors;

class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 0, 2, 1, 1, 2, 2};

        new Solution().sortColors(nums);
        System.out.println("---");

    }

    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0)
                swap(nums, i++, left++);
            else if (nums[i] == 2)
                swap(nums, i, right--);
            else
                i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
} 

