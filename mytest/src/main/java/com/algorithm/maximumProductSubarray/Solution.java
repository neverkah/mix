package com.algorithm.maximumProductSubarray;

class Solution {


    public static void main(String[] args) {

        int[] nums = new int[]{2,3,-2,4};

        System.out.println(new Solution().maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int maxNeg = nums[0] < 0 ? nums[0] : Integer.MIN_VALUE;
        boolean maxNegExists = nums[0] < 0;
        // 累积的乘积
        int cumPro = nums[0] == 0 ? 1 : nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cumPro = cumPro * nums[i];
            if (cumPro > 0) {
                result = Math.max(result, cumPro);
            } else if (cumPro < 0) {
                if (maxNegExists) {
                    result = Math.max(result, cumPro / maxNeg);
                }
                maxNeg = Math.max(maxNeg, cumPro);
                maxNegExists = true;
            } else {
                maxNeg = Integer.MIN_VALUE;
                maxNegExists = false;
                result = Math.max(result, nums[i]);
                cumPro = 1;
            }
        }
        return result;
    }
}