package com.algorithm.maximumProductSubarray2;

class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 2};
        System.out.println(new Solution().maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        int cumProduct = 1;
        int firstNegIdx = -1;
        int cumProductFirstNegIdx = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            cumProduct = cumProduct * nums[i];
            result = Math.max(result, cumProduct);
            if (nums[i] < 0) {
                if (firstNegIdx == -1) {
                    firstNegIdx = i;
                    cumProductFirstNegIdx = cumProduct;
                }
            }
            if (nums[i] == 0) {
                firstNegIdx = -1;
                cumProduct = 1;
                cumProductFirstNegIdx = Integer.MIN_VALUE;
            }
            if (i + 1 == nums.length || nums[i + 1] == 0) {
                if (cumProduct < 0 && i > firstNegIdx) {
                    result = Math.max(result, cumProduct / cumProductFirstNegIdx);
                }

            }
        }
        return result;
    }
}