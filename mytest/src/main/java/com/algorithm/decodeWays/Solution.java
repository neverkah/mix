package com.algorithm.decodeWays;

import java.util.Arrays;

/**
 * 递归方法
 */
class Solution {



    private String s;
    private int[] memo;

    public static void main(String[] args) {

        String s = "226";

        // System.out.println(new Solution().numDecodings(s));
        for (int i = 1; i <= 26; i++) {
            System.out.println("set.add(\"" + i + "\");");
        }


    }

    public int numDecodings(String s) {
        this.memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        this.s = s;


        return numDecodings(0);
    }

    public int numDecodings(int beginIdx) {

        if (memo[beginIdx] > -1) {
            return memo[beginIdx];
        }


        if (beginIdx == s.length()) {
            memo[beginIdx] = 1;
            return 1;
        }


        int nums = 0;
        if (canDecode(beginIdx, 1)) {
            nums += numDecodings(beginIdx + 1);
        }

        if (canDecode(beginIdx, 2)) {
            nums += numDecodings(beginIdx + 2);
        }

        memo[beginIdx] = nums;
        return nums;
    }

    boolean canDecode(int beginIdx, int length) {
        if (beginIdx >= s.length() || beginIdx + length > s.length()) {
            return false;
        }


        if (length == 1) {
            return s.charAt(beginIdx) != '0';
        }

        if (length == 2) {
            return s.charAt(beginIdx) != '0' && ((s.charAt(beginIdx) - '0') * 10 + (s.charAt(beginIdx + 1) - '0') <= 26);


        }

        return  false;


    }
}