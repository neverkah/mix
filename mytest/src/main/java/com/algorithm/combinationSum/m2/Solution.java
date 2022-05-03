package com.algorithm.combinationSum.m2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> comList;
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.comList = new ArrayList<>();
        this.candidates = candidates;
        int N = candidates.length;
        dfs(N - 1, target, new ArrayList<Integer>());
        return comList;
    }

    private void dfs(int index, int target, List<Integer> suffix) {
        if (index == 0) {
            if (target == 0) {
                comList.add(suffix);
                return;
            } else {
                rec(index, target, suffix);
            }
        } else {
            dfs(index - 1, target, suffix);
            rec(index, target, suffix);
        }
    }

    private void rec(int index, int target, List<Integer> suffix) {
        if (target - candidates[index] >= 0) {
            List<Integer> integerList = new ArrayList<>(suffix);
            integerList.add(candidates[index]);
            dfs(index, target - candidates[index], integerList);
        }
    }
}