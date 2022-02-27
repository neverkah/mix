package com.algorithm.permutations;

import java.util.LinkedList;
import java.util.List;

class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> integerListInitial = new LinkedList<>();
        integerListInitial.add(nums[0]);
        LinkedList<List<Integer>> res = new LinkedList<>();
        res.add(integerListInitial);
        for (int i = 1; i < nums.length; i++) {
            int size = res.size();
            for (int k = 0; k < size; k++) {
                List<Integer> integers = res.pop();
                for (int m = 0; m <= i; m++) {
                    List<Integer> integersAdd = new LinkedList<>();
                    integersAdd.addAll(integers);
                    integersAdd.add(m, nums[i]);
                    res.add(integersAdd);
                }
            }
        }
        return res;
    }
}