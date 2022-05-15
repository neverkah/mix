package com.algorithm.minimumSizeSubarraySum;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int N = nums.length;
        int sum = 0;
        while (right < N) {
            sum += nums[right];
            right++;
            while (left < right && sum >= target) {
                minLen = Math.min(minLen, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}