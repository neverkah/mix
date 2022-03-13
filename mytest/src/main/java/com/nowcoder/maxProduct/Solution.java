package com.nowcoder.maxProduct;

public class Solution {
    public double maxProduct(double[] arr) {
        if (arr.length == 0) return 0;
        double max = arr[0], min = arr[0];
        double maxRes = Long.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > 0) {
                max = Math.max(arr[i], max * arr[i]);
                min = Math.min(arr[i], min * arr[i]);
            } else {
                double lastMax = max;
                max = Math.max(arr[i], min * arr[i]);
                min = Math.min(arr[i], lastMax * arr[i]);
            }
            maxRes = Math.max(maxRes, max);
        }
        return maxRes;
    }
}