package com.algorithm.subarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            Map<Integer, Integer> newMap = new HashMap<>();
            for (Integer key : map.keySet()) {
                newMap.put(key + num, map.get(key));
                if (key + num == k) {
                    res += map.get(key);
                }
            }
            if (num == k) {
                res += 1;
            }
            newMap.put(num, newMap.getOrDefault(num, 0) + 1);
            map = newMap;
        }
        return res;
    }
}