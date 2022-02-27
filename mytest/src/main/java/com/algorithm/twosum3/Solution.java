package com.algorithm.twosum3;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int binarySearch(Number[] numbers, int start, int end, int key) {
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (numbers[mid].num == key) {
                return mid;
            } else if (numbers[mid].num < key) {
                start = mid + 1;
            } else if (numbers[mid].num > key) {
                end = mid - 1;
            }
        }
        return -1;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        Number[] numbers = new Number[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = new Number(nums[i], i);
        }
        Arrays.sort(numbers, Comparator.comparingInt(n -> n.num));
        for (int i = 0; i < numbers.length - 1; i++) {
            int secondIndex = binarySearch(numbers, i + 1, nums.length - 1, target - numbers[i].num);
            if (secondIndex != -1) {
                res[0] = numbers[i].index;
                res[1] = numbers[secondIndex].index;
                break;
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