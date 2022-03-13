package com.nowcoder.localMin;

public class Solution {
    public int getLessIndex(int[] arr) {
        int N = arr.length;
        if (N == 0) {
            return -1;
        }
        if (N == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[N - 1] < arr[N - 2]) {
            return N - 1;
        }
        int left = 1;
        int right = N - 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid - 1] < arr[mid]) {
                right = mid - 1;
            } else if (arr[mid + 1] < arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return 0;//随意返回，程序不会运行到这儿，不加这句，编译不过
    }

    public int getLessIndex2(int[] arr) {
        int N = arr.length;
        if (N == 0) {
            return -1;
        }
        if (N == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[N - 1] < arr[N - 2]) {
            return N - 1;
        }
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i - 1] && arr[i] <= arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}