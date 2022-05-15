package com.algorithm.repeatedDnaSequences;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int N = s.length();
        Map<String, Integer> map = new HashMap<>();
        List<String> resList = new ArrayList<>();
        for (int i = 0; i <= N - 10; i++) {
            String sub = s.substring(i, i + 10);
            int count = map.getOrDefault(sub, 0) + 1;
            map.put(sub, count);
            if (count == 2) {
                resList.add(sub);
            }
        }
        return resList;
    }
}