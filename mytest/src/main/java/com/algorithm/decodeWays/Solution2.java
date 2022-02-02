package com.algorithm.decodeWays;

/**
 * 动态规划 空间复杂度O(N)
 */
class Solution2 {
    private String s;

    public int numDecodings(String s) {
        this.s = s;
        int[] nums = new int[s.length() + 1];
        nums[s.length()] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int temp = 0;
            if (canDecode(i, 1)) {
                temp += nums[i + 1];
            }
            if (canDecode(i, 2)) {
                temp += nums[i + 2];
            }
            nums[i] = temp;
        }
        return nums[0];
    }

    boolean canDecode(int beginIdx, int length) {
        if (beginIdx + length > s.length()) {
            return false;
        }
        if (length == 1) {
            return s.charAt(beginIdx) != '0';
        }
        if (length == 2) {
            return (s.charAt(beginIdx) == '1')
                    || (s.charAt(beginIdx) == '2' && s.charAt(beginIdx + 1) >= '0' && s.charAt(beginIdx + 1) <= '6');
        }
        return false;
    }
}