package com.algorithm.minimumWindowSubstring;

public class T {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(new Solution2().minWindow(s, t));
    }
}
