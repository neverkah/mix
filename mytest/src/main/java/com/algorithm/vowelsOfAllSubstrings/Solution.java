package com.algorithm.vowelsOfAllSubstrings;

class Solution {
    public long countVowels(String word) {
        long sum = 0;
        // 以i结尾的子字符串的元音总个数
        long v = 0;
        char[] wordArr = word.toCharArray();
        for (int i = 0; i < wordArr.length; i++) {
            if (wordArr[i] == 'a' || wordArr[i] == 'e' || wordArr[i] == 'i' || wordArr[i] == 'o' || wordArr[i] == 'u') {
                v += i + 1;
            }
            sum += v;
        }
        return sum;
    }
}