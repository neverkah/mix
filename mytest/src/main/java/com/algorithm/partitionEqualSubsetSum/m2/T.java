package com.algorithm.partitionEqualSubsetSum.m2;

import org.junit.Test;

import java.math.BigDecimal;

public class T {

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};

        System.out.println(new Solution().canPartition(nums));

    }

    @Test
    public void test1() {

        BigDecimal b = new BigDecimal(1);

        for (int i = 1; i <= 10000; i++) {
            b = b.multiply(new BigDecimal(2));
        }

        System.out.println(b);

    }
}
