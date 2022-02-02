package com.algorithm.decodeWays;

/**
 * 动态规划 空间复杂度O(1)
 */
class Solution3 {

    private String s;




    public int numDecodings(String s) {

        this.s = s;

        int f1 = 1;
        int f2 = 0;

        int temp = 0;
        for (int i = s.length() - 1; i >= 0; i--) {

            temp = 0;
            if (canDecode(i, 1)) {
                temp += f1;
            }

            if (canDecode(i, 2)) {
                temp += f2;
            }

            f2 = f1;
            f1 = temp;
        }


        return f1;
    }


    boolean canDecode(int beginIdx, int length) {
        if (beginIdx + length > s.length()) {
            return false;
        }


        if (length == 1) {
            return s.charAt(beginIdx) != '0';
        }

        if (length == 2) {
            return s.charAt(beginIdx) != '0' && ((s.charAt(beginIdx) - '0') * 10 + (s.charAt(beginIdx + 1) - '0') <= 26);


        }

        return false;


    }
}