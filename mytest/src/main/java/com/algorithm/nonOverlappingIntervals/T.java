package com.algorithm.nonOverlappingIntervals;

import org.junit.Test;

public class T {

    public static void main(String[] args) {
        int[][] ints = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(new Solution().eraseOverlapIntervals(ints));

    }

    @Test
    public void test1() {
        int[][] ints = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println(new Solution().eraseOverlapIntervals(ints));
    }

    @Test
    public void test2() {
        int[][] ints = {{1, 2}, {2, 3}};
        System.out.println(new Solution().eraseOverlapIntervals(ints));
    }
}
