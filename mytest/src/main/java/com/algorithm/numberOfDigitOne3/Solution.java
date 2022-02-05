package com.algorithm.numberOfDigitOne3;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countDigitOne(100));
    }

    public int countDigitOne(int n) {
        return dfs(n);
    }

    public int dfs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n >= 1 && n <= 9) {
            return 1;
        }
        int pow = 1;
        // n/10 临时变量 为了计算n有多少位
        int temp = n;
        while ((temp = temp / 10) > 0) {
            pow *= 10;
        }
        // n的总位数为n,则为n-1位的最大整数，如n总位数为4，则为999;
        int maxNum = pow - 1;
        // n为1234 tail为234
        int tail = n % pow;
        // n为1234 head为1
        int head = n / pow;
        if (head == 1) {
            return dfs(maxNum) + tail + 1 + dfs(tail);
        } else {
            return dfs(maxNum) * head + pow + dfs(tail);
        }
    }
}