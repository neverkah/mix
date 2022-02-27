package com.algorithm.letterCombinationsOfAPhoneNumber;

import org.junit.Test;

public class TT {

    public static void main(String[] args) {
        String digits = "23";
        for (String letterCombination : new Solution().letterCombinations(digits)) {
            System.out.println(letterCombination);
        }
    }

    @Test
    public void test1() {

        System.out.println((char) ('a' + ('3' - '2') * 3));
    }
}
