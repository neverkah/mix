package com.algorithm.twoSum2;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Number[] numbers = new Number[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = new Number(nums[i], i);
        }
        Arrays.sort(numbers, Comparator.comparingInt(n -> n.num));
        int[] res = new int[2];
        int begin = 0, end = nums.length - 1;
        while (begin < end) {
            if (begin > 0 && numbers[begin].num == numbers[begin - 1].num) {
                begin++;
                continue;
            }
            if (numbers[begin].num + numbers[end].num > target) {
                end--;
            } else if (numbers[begin].num + numbers[end].num == target) {
                res[0] = numbers[begin].index;
                res[1] = numbers[end].index;
                break;
            } else {
                begin++;
            }
        }
        return res;
    }
}

class Number {
    int num;
    int index;

    public Number(int num, int index) {
        this.num = num;
        this.index = index;
    }
}