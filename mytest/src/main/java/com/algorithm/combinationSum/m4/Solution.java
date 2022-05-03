package com.algorithm.combinationSum.m4;

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
        if (index == 0) {
            if (target == 0) {
                comList.add(new ArrayList<>(suffix));
                return;
            }
            rec(index, target);
        } else {
            if (target == 0) {
                comList.add(new ArrayList<>(suffix));
                return;
            }
            dfs(index - 1, target);
            if (target - candidates[index] >= 0) {
                for (int i = 1; i <= target / candidates[index]; i++) {
                    for (int j = 0; j < i; j++) {
                        suffix.add(candidates[index]);
                    }
                    dfs(index - 1, target - candidates[index] * i);
                    for (int j = 0; j < i; j++) {
                        suffix.remove(suffix.size() - 1);
                    }
                }
            }
        }
    }

    private void rec(int index, int target) {
        if (target - candidates[index] >= 0) {
            suffix.add(candidates[index]);
            dfs(index, target - candidates[index]);
            suffix.remove(suffix.size() - 1);
        }
    }
}