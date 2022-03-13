package com.algorithm.boatsToSavePeople;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/boats-to-save-people/
 */
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int start = 0, end = people.length - 1;
        int boatsNum = 0;
        while (start < end) {
            if (people[start] + people[end] <= limit) {
                start++;
            }
            boatsNum++;
            end--;
        }
        return start == end ? ++boatsNum : boatsNum;
    }
}