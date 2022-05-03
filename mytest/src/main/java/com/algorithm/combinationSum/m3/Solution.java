package com.algorithm.combinationSum.m3;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> comList;
    private int[] candidates;
    private List<Integer> suffix;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.comList = new ArrayList<>();
        this.candidates = candidates;
        this.suffix = new ArrayList<>();
        int N = candidates.length;
        dfs(N - 1, target);
        return comList;
    }

    private void dfs(int index, int target) {
        if (target == 0) {
            comList.add(new ArrayList<>(suffix));
            return;
        }
        if (index > 0) {
            dfs(index - 1, target);
        }
        if (target - candidates[index] >= 0) {
            suffix.add(candidates[index]);
            dfs(index, target - candidates[index]);
            suffix.remove(suffix.size() - 1);
        }
    }
}