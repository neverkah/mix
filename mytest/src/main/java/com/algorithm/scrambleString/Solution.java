package com.algorithm.scrambleString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<String, List<String>> memo = new HashMap<>();
    String s1;
    String s2;
    boolean scramble = false;

    public static void main(String[] args) {


        String s1 = "abcdbdacbdac";
        String s2 = "bdacabcdbdac";

        System.out.println(new Solution().isScramble(s1, s2));
    }

    public boolean isScramble(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        scramble(s1);
        return scramble;
    }

    List<String> scramble(String s) {
        List<String> memoResult = memo.get(s);
        if (null != memoResult) {
            return memoResult;
        }
        List<String> scrambleList = new ArrayList<>();
        if (s.length() == 1) {
            scrambleList.add(s);
            if (s.equals(s1) && s.equals(s2)) {
                scramble = true;
                return scrambleList;
            }
            memo.put(s, scrambleList);
            return scrambleList;
        }
        for (int i = 1; i < s.length(); i++) {
            for (String head : scramble(s.substring(0, i))) {
                for (String tail : scramble(s.substring(i))) {
                    if (s.equals(s1) && ((head + tail).equals(s2) || (head + tail).equals(s2))) {
                        scramble = true;
                        return scrambleList;
                    }
                    scrambleList.add(head + tail);
                    scrambleList.add(tail + head);
                }
            }
        }
        memo.put(s, scrambleList);
        return scrambleList;
    }
}