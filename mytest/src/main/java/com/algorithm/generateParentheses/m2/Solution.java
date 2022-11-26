package com.algorithm.generateParentheses.m2;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法，核心思想左括号一定要大于等于右括号
 */
class Solution {
    final static char BRACKET_LEFT = '(';
    final static char BRACKET_RIGHT = ')';
    List<String> rs = new ArrayList<>();
    int size;
    int N;

    public List<String> generateParenthesis(int n) {
        this.N = n;
        char[] cs = new char[2 * n];
        backtrack(0, 0, cs);
        return rs;
    }

    private void backtrack(int l, int r, char[] cs) {
        if (size == 2 * N) {
            rs.add(new String(cs));
            return;
        }
        if (l > r) {
            cs[size++] = BRACKET_RIGHT;
            backtrack(l, r + 1, cs);
            size--;
        }
        if (l < N) {
            cs[size++] = BRACKET_LEFT;
            backtrack(l + 1, r, cs);
            size--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (String generateParenthesis : solution.generateParenthesis(4)) {
            System.out.println(generateParenthesis);
        }
    }
}