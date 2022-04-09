package com.algorithm.mergeIntervals;

public class T {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        for (int[] ints : new Solution().merge(intervals)) {
            System.out.println(ints[0] + " " + ints[1]);
        }

    }
}
