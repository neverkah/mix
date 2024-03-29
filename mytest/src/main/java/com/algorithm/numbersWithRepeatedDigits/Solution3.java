package com.algorithm.numbersWithRepeatedDigits;

class Solution3 {
    static int[] pow;
    int n;
    int[] nums;
    boolean[][] existInHigherDigits;

    static {
        pow = new int[9];
        pow[0] = 10;
        for (int i = 1; i < pow.length; i++) {
            pow[i] = pow[i - 1] * 10;
        }
    }

    public int numDupDigitsAtMostN(int n) {
        this.n = n;
        this.nums = new int[10];
        int t = n;
        int N = 0;
        while (t > 0) {
            nums[N++] = t % 10;
            t /= 10;
        }
        boolean[] digit = new boolean[10];
        // existsInHigerDigits[i][j] 表示第i位取j时，是否与n的比i高的位的数字重复
        this.existInHigherDigits = new boolean[N][10];
        digit[nums[N - 1]] = true;
        for (int i = N - 2; i >= 0; i--) {
            for (int num = 0; num <= nums[i]; num++) {
                existInHigherDigits[i][num] = digit[num];
            }
            digit[nums[i]] = true;
        }
        return dfs(N - 1, false, true, 0);
    }

    int dfs(int index, boolean repeated, boolean cling, int nonLeadingZeroCount) {
        if (repeated) {
            if (cling) {
                return n % pow[index] + 1;
            }
            return pow[index];
        }
        int res = 0;
        if (cling) {
            for (int i = 0; i <= nums[index]; i++) {
                if (index > 0) {
                    res += dfs(index - 1, existInHigherDigits[index][i], i == nums[index], nonLeadingZeroCount + i == 0 ? 0 : nonLeadingZeroCount + 1);
                } else {
                    res += existInHigherDigits[index][i] ? 1 : 0;
                }
            }
            return res;
        }
        if (index > 0) {
            res += nonLeadingZeroCount * dfs(index - 1, true, false, nonLeadingZeroCount + 1);
            if (nonLeadingZeroCount == 0) {
                res += dfs(index - 1, false, false, 0);
                res += 9 * dfs(index - 1, false, false, 1);
            } else {
                res += (10 - nonLeadingZeroCount) * dfs(index - 1, false, false, nonLeadingZeroCount + 1);
            }
        } else {
            res += nonLeadingZeroCount;
        }
        return res;
    }
}