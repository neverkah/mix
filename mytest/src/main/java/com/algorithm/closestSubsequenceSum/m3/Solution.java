package com.algorithm.closestSubsequenceSum.m3;

import java.util.Arrays;

class Solution {
	int p;
	int[] nums;

	public int minAbsDifference(int[] nums, int goal) {
		this.nums = nums;
		int len = nums.length;
		int mid = len >> 1;
		int len1 = 1 << mid, len2 = 1 << (len - mid);
		int[] nums1 = new int[len1];// 可能的和的集合，一半
		int[] nums2 = new int[len2];// 可能的和的集合，另一半
		p = 0;
		sum(0, mid, 0, nums1);
		p = 0;
		sum(mid, len, 0, nums2);
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int ans = Integer.MAX_VALUE;
		//
		for (int i = 0, j = len2 - 1; i < len1; i++) {
			int rest = goal - nums1[i];
			while (j > 0 && Math.abs(rest - nums2[j]) >= Math.abs(rest - nums2[j - 1])) {
				j--;
			}
			ans = Math.min(ans, Math.abs(rest - nums2[j]));
		}
		return ans;
	}

	private void sum(int L, int R, int sum, int[] nums) {
		if (L == R) {
			nums[p++] = sum;
			return;
		}
		this.sum(L + 1, R, sum, nums);
		this.sum(L + 1, R, sum + this.nums[L], nums);
	}
}

