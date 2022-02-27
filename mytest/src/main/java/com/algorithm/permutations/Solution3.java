package com.algorithm.permutations;

import java.util.LinkedList;
import java.util.List;

class Solution3 {
    int[] nums;
    LinkedList<List<Integer>> res;

    public void permute(List<Integer> list, int index) {
        if (index == nums.length) {
            res.add(list);
            return;
        }
        for (int i = 0; i <= index; i++) {
            List<Integer> integerList = new LinkedList<>();
            integerList.addAll(list);
            integerList.add(i, nums[index]);
            permute(integerList, index + 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        res = new LinkedList<>();
        permute(new LinkedList<Integer>(), 0);
        return res;
    }
}