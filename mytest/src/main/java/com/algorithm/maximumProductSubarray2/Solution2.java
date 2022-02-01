package com.algorithm.maximumProductSubarray2;

class Solution2 {


    public static void main(String[] args) {
        int[] nums = new int[]{0, 2};
        System.out.println(new Solution2().maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        int cumProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            cumProduct = cumProduct * nums[i];
            result = Math.max(result, cumProduct);
            if (nums[i] == 0) {
                cumProduct = 1;
            }
        }
        cumProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            cumProduct = cumProduct * nums[i];
            result = Math.max(result, cumProduct);
            if (nums[i] == 0) {
                cumProduct = 1;
            }
        }
        return result;
    }
}