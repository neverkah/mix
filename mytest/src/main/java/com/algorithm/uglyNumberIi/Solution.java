package com.algorithm.uglyNumberIi;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(11));
    }

    public int nthUglyNumber(int n) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        int[] factors = new int[]{2, 3, 5};
        minHeap.offer(1);
        int uglyNum = -1;
        for (int i = 1; i <= n; i++) {
            uglyNum = minHeap.poll();
            for (int factor : factors) {
                if (uglyNum <= Integer.MAX_VALUE / factor) {
                    int futureUglyNum = uglyNum * factor;
                    if (set.add(futureUglyNum)) {
                        minHeap.offer(futureUglyNum);
                    }
                }
            }
        }
        return uglyNum;
    }
}