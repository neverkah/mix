package com.algorithm.maximumProductSubarray;

class Solution2 {


    public static void main(String[] args) {

        int[] nums = new int[]{0, -2, -3};

        System.out.println(new Solution2().maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int maxNeg = Integer.MIN_VALUE;
        boolean maxNegExists = false;
        // 累积的乘积
        int cumPro = 1;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            cumPro = cumPro * nums[i];
            if (cumPro > 0) {
                result = Math.max(result, cumPro);
            } else if (cumPro < 0) {
                if (maxNegExists) {
                    result = Math.max(result, cumPro / maxNeg);
                } else {
                    result = Math.max(result, nums[i]);
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