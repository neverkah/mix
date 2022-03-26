package com.algorithm.maximumEarningsFromTaxi.m3;

public class T {

    public static void main(String[] args) {
                int n = 20;
        int[][] rides = {{1, 6, 1}, {3, 10, 2}, {10, 12, 3}, {11, 12, 2}, {12, 15, 2}, {13, 18, 1}};

//        int n = 5;
//        int[][] rides = {{2, 5, 4}, {1, 5, 1}};

        System.out.println(new Solution().maxTaxiEarnings(n, rides));
    }
}
