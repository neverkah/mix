package com.algorithm.numbersWithRepeatedDigits;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().numDupDigitsAtMostN(110));
    }

    public int numDupDigitsAtMostN(int N) {
        return N - dp(N);
    }

    public int dp(int n) {
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(n % 10);
            n /= 10;
        }
        int k = digits.size();

        int[] used = new int[10];
        int total = 0;

        for (int i = 1; i < k; i++) {
            total += 9 * A(9, i - 1);
        }

        for (int i = k - 1; i >= 0; i--) {
            int num = digits.get(i);

            for (int j = i == k - 1 ? 1 : 0; j < num; j++) {
                if (used[j] != 0) {
                    continue;
                }
                total += A(10 - (k - i), i);
            }

            if (++used[num] > 1) {
                break;
            }

            if (i == 0) {
                total += 1;
            }
        }
        return total;
    }

    public int fact(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public int A(int m, int n) {
        return fact(m) / fact(m - n);
    }


}
