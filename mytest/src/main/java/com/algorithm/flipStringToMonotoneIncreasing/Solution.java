package com.algorithm.flipStringToMonotoneIncreasing;

class Solution {
    public int minFlipsMonoIncr(String s) {
        int x0 = 0, x1 = 0;
        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            int lastX0 = x0;
            x0 = (c == '0' ? 0 : 1) + x0;
            x1 = (c == '1' ? 0 : 1) + Math.min(lastX0, x1);
        }
        return Math.min(x0, x1);
    }
}