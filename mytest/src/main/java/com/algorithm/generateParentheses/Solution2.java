package com.algorithm.generateParentheses;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    List<String> parenthesisList = new ArrayList<>();

    public static void main(String[] args) {
        for (String s : new Solution2().generateParenthesis(15)) {
            System.out.println(s);
        }
    }

    public List<String> generateParenthesis(int n) {
        dfs("", n, n);
        return parenthesisList;
    }

    public void dfs(String str, int left, int right) {
        if (left == 0 && right == 0) {
            parenthesisList.add(str);
            return;
        }
        if (left == right) {
            dfs(str + "(", left - 1, right);
        } else if (left < right) {
            if (left >= 1) {
                dfs(str + "(", left - 1, right);
            }
            if (right >= 1) {
                dfs(str + ")", left, right - 1);
            }
        }
    }
}