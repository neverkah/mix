package com.algorithm.implementStrstr;

class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.length() - i < needle.length()) {
                return -1;
            }
            int equalLength = 0;
            int cmi = i;
            for (int j = 0; j < needle.length() && cmi < haystack.length(); j++) {
                if (haystack.charAt(cmi++) == needle.charAt(j)) {
                    equalLength++;
                } else {
                    break;
                }
            }
            if (equalLength == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}