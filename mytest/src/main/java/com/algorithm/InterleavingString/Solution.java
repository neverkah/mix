package com.algorithm.InterleavingString;

import java.util.Arrays;

class Solution {
    private String s1;
    private String s2;
    private String s3;
    private int[][] memo;


    public static void main(String[] args) {
        String s1 = "", s2 = "", s3 = "";
        System.out.println(new Solution().isInterleave(s1, s2, s3));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s3.length() == 0 && s2.length() == 0 && s1.length() == 0) {
            return true;
        }
        if (s3.length() == 0) {
            return false;
        }
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;

        memo = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length() + 1; i++) {

            Arrays.fill(memo[i], -1);

        }
        return isInterleave(0, 0);
    }

    public boolean isInterleave(int begin1, int begin2) {
        if (memo[begin1][begin2] > -1) {
            return memo[begin1][begin2] == 0 ? false : true;
        }
        boolean isInterleave = false;

        if (begin1 + begin2 == s3.length() - 1) {
            if ((begin1 < s1.length() && s3.charAt(s3.length() - 1) == s1.charAt(begin1))
                    || (begin2 < s2.length() && s3.charAt(s3.length() - 1) == s2.charAt(begin2))
            ) {
                isInterleave = true;
            }
            memo[begin1][begin2] = (isInterleave ? 1 : 0);
            return isInterleave;
        }
        if (begin1 < s1.length() && s3.charAt(begin1 + begin2) == s1.charAt(begin1)) {
            isInterleave = isInterleave(begin1 + 1, begin2);
        }
        if (!isInterleave && begin2 < s2.length() && s3.charAt(begin1 + begin2) == s2.charAt(begin2)) {
            isInterleave = isInterleave(begin1, begin2 + 1);
        }
        memo[begin1][begin2] = isInterleave ? 1 : 0;
        return isInterleave;
    }
}