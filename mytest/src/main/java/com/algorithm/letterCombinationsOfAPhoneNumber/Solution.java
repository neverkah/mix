package com.algorithm.letterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res;
    char[] digitsArr;

    public List<String> letterCombinations(String digits) {
        this.res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        this.digitsArr = digits.toCharArray();
        letterCombinations("", 0);
        return res;
    }

    private void letterCombinations(String prefix, int index) {
        if (index == digitsArr.length) {
            res.add(prefix);
            return;
        }
        for (Character c : getLetters(digitsArr[index])) {
            letterCombinations(prefix + c, index + 1);
        }
    }

    char[] getLetters(char num) {
        if (num >= '2' && num <= '6') {
            int first = (char) ('a' + (num - '2') * 3);
            return new char[]{(char) first, (char) (first + 1), (char) (first + 2)};
        } else if (num == '7') {
            return new char[]{'p', 'q', 'r', 's'};
        } else if (num == '9') {
            return new char[]{'w', 'x', 'y', 'z'};
        } else {
            return new char[]{'t', 'u', 'v'};
        }
    }
}