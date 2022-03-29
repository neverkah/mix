package com.algorithm.numbersWithRepeatedDigits;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution2 {
    int[] pow;
    int n;
    Set<Integer> clingSet;
    int NON_ZEROS = 0;
    Integer[] nums;

    public int numDupDigitsAtMostN(int n) {
        this.n = n;
        this.clingSet = new HashSet<>();
        pow = new int[9];
        pow[0] = 10;
        for (int i = 1; i < pow.length; i++) {
            pow[i] = pow[i - 1] * 10;
        }
        List<Integer> integerList = new ArrayList<>();
        int t = n;
        while (t > 0) {
            integerList.add(t % 10);
            t /= 10;
        }
        this.nums = new Integer[integerList.size()];
        integerList.toArray(this.nums);
        int N = integerList.size();
        return dfs(N - 1, false, true);
    }

    int dfs(int p, boolean repeated, boolean cling) {
        int res = 0;
        if (repeated) {
            if (cling) {
                res = n % pow[p] + 1;
            } else {
                res = pow[p];
            }
        } else {
            if (cling) {
                for (int i = 0; i <= nums[p]; i++) {
                    if (i == 0) {
                        if (NON_ZEROS == 0) {
                        } else {
                            NON_ZEROS++;
                        }
                    } else {
                        NON_ZEROS++;
                    }
                    if (p > 0) {
                        boolean exists = clingSet.contains(i);
                        if (NON_ZEROS > 0 && i == nums[p]) {
                            clingSet.add(nums[p]);
                        }
                        res += dfs(p - 1, exists, i == nums[p]);
                    } else {
                        res += clingSet.contains(i) ? 1 : 0;
                    }
                    if (NON_ZEROS > 0) {
                        NON_ZEROS--;
                    }
                }
            } else {
                if (p > 0) {
                    for (int i = 0; i < NON_ZEROS; i++) {
                        res += dfs(p - 1, true, false);
                    }
                    for (int i = 0; i < 10 - NON_ZEROS; i++) {
                        if (i == 0) {
                            if (NON_ZEROS == 0) {
                            } else {
                                NON_ZEROS++;
                            }
                        } else {
                            NON_ZEROS++;
                        }
                        res += dfs(p - 1, false, false);
                        if (NON_ZEROS > 0) {
                            NON_ZEROS--;
                        }
                    }
                } else {
                    res += NON_ZEROS;
                }
            }
        }
        return res;
    }
}