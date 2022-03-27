package com.algorithm.findAllGoodStrings;

import java.util.HashMap;
import java.util.Map;

class Solution {
    static int M = 1000000007;
    static Map<String, Integer>[] memo;
    static int N;
    static String MIN_PREV = "-1", MAX_NEXT = "1";

    static String neighbor(String s, int n, boolean next) {
        char[] chars = new char[n];
        for (int i = 0; i < chars.length; i++) {
            if (i < s.length()) {
                chars[i] = s.charAt(i);
            } else {
                chars[i] = next ? 'z' : 'a';
            }
        }
        int carry = 0;
        if (next) {
            for (int i = n - 1; i >= 0; i--) {
                char bit = (char) (chars[i] + (i == n - 1 ? 1 : 0) + carry);
                if (bit > 'z') {
                    chars[i] = 'a';
                    carry = 1;
                } else {
                    chars[i] = bit;
                    carry = 0;
                }
            }
        } else {

            for (int i = n - 1; i >= 0; i--) {
                char bit = (char) (chars[i] + (i == n - 1 ? -1 : 0) + carry);
                if (bit < 'a') {
                    chars[i] = 'z';
                    carry = -1;
                } else {
                    chars[i] = bit;
                    carry = 0;
                }
            }
        }
        return carry == 0 ? new String(chars, 0, n) : String.valueOf(carry);
    }

    static String pad(char c, int n, boolean least) {
        char[] chars = new char[n];
        chars[0] = c;
        for (int i = 1; i < n; i++) {
            chars[i] = least ? 'a' : 'z';
        }
        return new String(chars);
    }

    static String prev(String s, int n) {
        return neighbor(s, n, false);
    }

    static String next(String s, int n) {
        return neighbor(s, n, true);
    }

    public static int findGoodStrings(int n, String s1, String s2, String evil) {
        N = n;
        memo = new HashMap[n + 1];
        for (int i = 1; i <= n; i++) {
            memo[i] = new HashMap<>();
        }
        return dfs(n, s1, s2, evil);
    }

    public static int dfs(int n, String s1, String s2, String evil) {
        if (memo[n].containsKey(s1 + s2)) {
            return memo[n].get(s1 + s2);
        }
        if (s1.compareTo(s2) > 0) {
            return 0;
        }
        int res = 0;
        if (evil != null && evil.length() > n) {
            evil = null;
        }
        if (n == 1) {
            res = s2.charAt(0) - s1.charAt(0) + 1 - (evil != null && evil.charAt(0) >= s1.charAt(0) && evil.charAt(0) <= s2.charAt(0) ? 1 : 0);
            memo[n].put(s1 + s2, res);
            return res;
        }
        if (s1.charAt(0) == s2.charAt(0)) {
            res = sm(n, s1, s2, evil);
            res %= M;
        } else {
            res += sm(n, s1, pad(s1.charAt(0), n, false), evil);
            res %= M;
            if (s2.charAt(0) - s1.charAt(0) > 1) {
                for (char c = (char) (s1.charAt(0) + 1); c < s2.charAt(0); c++) {
                    res += sm(n, pad(c, n, true), pad(c, n, false), evil);
                    res %= M;
                }
            }
            res += sm(n, pad(s2.charAt(0), n, true), s2, evil);
            res %= M;
        }
        memo[n].put(s1 + s2, res);
        return res;
    }

    static int sm(int n, String s1, String s2, String evil) {
        int res = 0;
        if (null != evil && evil.charAt(0) == s1.charAt(0) && s1.substring(0, evil.length()).compareTo(evil) <= 0 && s2.substring(0, evil.length()).compareTo(evil) >= 0) {
            String prev = prev(evil, n);
            if (!MIN_PREV.equals(prev) && s1.compareTo(prev) <= 0) {
                res += dfs(n - 1, s1.substring(1), prev.substring(1), evil);
            }
            res %= M;
            String next = next(evil, n);
            if (!MAX_NEXT.equals(next) && next.compareTo(s2) <= 0) {
                res += dfs(n - 1, next.substring(1), s2.substring(1), evil);
            }
            res %= M;
        } else {
            res += dfs(n - 1, s1.substring(1), s2.substring(1), evil);
            res %= M;
        }
        return res;
    }
}