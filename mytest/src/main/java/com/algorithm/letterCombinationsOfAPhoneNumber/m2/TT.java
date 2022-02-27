package com.algorithm.letterCombinationsOfAPhoneNumber.m2;

public class TT {

    public static void main(String[] args) {

        String digits = "23";
        for (String letterCombination : new Solution().letterCombinations(digits)) {
            System.out.println(letterCombination);
        }
    }
}
