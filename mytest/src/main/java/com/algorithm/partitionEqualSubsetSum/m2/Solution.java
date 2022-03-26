package com.algorithm.partitionEqualSubsetSum.m2;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 > 0) {
            return false;
        }
        sum /= 2;
        Set<Integer> subSumSet = new HashSet<>();
        for (int num : nums) {
            if (num == sum) {
                return true;
            }
            Integer[] subSumArr = new Integer[subSumSet.size()];
            subSumSet.toArray(subSumArr);
            for (int subSum : subSumArr) {
                if (subSum + num == sum) {
                    return true;
                }
                if (subSum + num < sum) {
                    subSumSet.add(subSum + num);
                }
            }
            subSumSet.add(num);
        }
        return false;
    }
}