package com.algorithm.generateParentheses;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String>[][] memo;

    public static void main(String[] args) {
        for (String s : new Solution().generateParenthesis(8)) {
            System.out.println(s);
        }
    }

    public List<String> generateParenthesis(int n) {
        memo = new ArrayList[n + 1][n + 1];
        return dfs(n, n);
    }

    public List<String> dfs(int left, int right) {

        if (memo[left][right] != null) {
            return memo[left][right];
        }

        List<String> parenthesisList = new ArrayList<>();
        if (left == 0 && right == 1) {
            parenthesisList.add(")");
            memo[left][right] = parenthesisList;
            return parenthesisList;
        }
        if (left == right) {
            for (String s : dfs(left - 1, right)) {
                parenthesisList.add("(" + s);
            }
        } else if (left < right) {
            if (left >= 1) {
                for (String s : dfs(left - 1, right)) {
                    parenthesisList.add("(" + s);
                }
            }
            if (right >= 1)
                for (String s : dfs(left, right - 1)) {
                    parenthesisList.add(")" + s);
                }
        }
        memo[left][right] = parenthesisList;
        return parenthesisList;
    }
}