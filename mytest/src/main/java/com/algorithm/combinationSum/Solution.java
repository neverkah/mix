package com.algorithm.combinationSum;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>[] dp = new List[target + 1];
        for (int i = 0; i < candidates.length; i++) {
            List<Integer> integerList0 = new ArrayList<>();
            List<List<Integer>> comList0 = new ArrayList<>();
            comList0.add(integerList0);
            dp[0] = comList0;
            for (int j = 1; j <= target; j++) {
                List<List<Integer>> comList = new ArrayList<>();
                if (dp[j] != null) {
                    for (List<Integer> integersT : dp[j]) {
                        List<Integer> integerList = new ArrayList<>(integersT);
                        comList.add(integerList);
                    }
                }
                if (j >= candidates[i]) {
                    if (dp[j - candidates[i]] != null) {
                        for (List<Integer> integersT : dp[j - candidates[i]]) {
                            List<Integer> integerList = new ArrayList<>(integersT);
                            integerList.add(candidates[i]);
                            comList.add(integerList);
                        }
                    }
                }
                dp[j] = comList;
            }
        }
        return dp[target] == null ? new ArrayList<>() : dp[target];
    }
}