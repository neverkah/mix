package com.algorithm.rotateFunction;

class Solution {
    int length;
    int[] accuSum;
    int[] nums;

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 6};
        Solution solution = new Solution();
        System.out.println(solution.maxRotateFunction(nums));
    }

    public int maxRotateFunction(int[] nums) {
        this.nums = nums;
        this.length = nums.length;
        accuSum = new int[length];
        accuSum[0] = nums[0];
        for (int i = 1; i < length; i++) {
            accuSum[i] = accuSum[i - 1] + nums[i];
        }
        int maxFIndex = 0;
        for (int i = 1; i < length; i++) {
            maxFIndex = compare(maxFIndex, i);
        }
        return calF(maxFIndex);
    }

    private int calF(int x) {
        int sum = 0;
        int index = x == 0 ? 0 : length - x;
        for (int i = 1; i < length; i++) {
            if (index + 1 > length - 1) {
                index = 0;
            } else {
                index++;
            }
            sum += nums[index] * i;
        }
        return sum;
    }

    // 比较F(c1) F(c2)的大小  F(c1)>F(c2) 返回c1 否则返回c2
    int compare(int c1, int c2) {
        int gap = c2 - c1;
        int c1Compare = accuSum[length - 1 - c1] - accuSum[length - 1 - c1 - gap];
        int c2Compare = accuSum[length - 1] - c1Compare;
        if (length - gap == gap) {
            return c1Compare > c2Compare ? c1 : c2;
        } else {
            return c1Compare * (length - gap) > c2Compare * gap ? c1 : c2;
        }
    }
}