package com.algorithm.permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution5 {
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        List<List<Integer>> res = null;
        res = permute(nums.length - 1);
        return res;
    }

    private List<List<Integer>> permute(int end) {
        if (end == 0) {
            List<Integer> integerList = new LinkedList<>();
            integerList.add(nums[0]);
            List<List<Integer>> res = new ArrayList<>();
            res.add(integerList);
            return res;
        }
        List<List<Integer>> beforeRes = permute(end - 1);
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> integerList : beforeRes) {
            for (int i = 0; i <= end; i++) {
                List<Integer> integerListAdd = new LinkedList<>();
                integerListAdd.addAll(integerList);
                integerListAdd.add(i, nums[end]);
                res.add(integerListAdd);
            }
        }
        return res;
    }
}