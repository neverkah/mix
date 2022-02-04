package com.algorithm.maximalSquare;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        char[][] matrix = new char[][]
                {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(new Solution().maximalSquare(matrix));
    }

    public int maximalSquare(char[][] matrix) {
        int result = 0;
        List<int[]>[][] regionListArr = new ArrayList[matrix.length][matrix[0].length];
        int continuousSize = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == '1') {
                continuousSize++;
            } else {
                continuousSize = 0;
            }
            List<int[]> regionResult = new ArrayList<>();
            if (continuousSize > 0) {
                int[] region = new int[]{continuousSize, 1};
                regionResult.add(region);
                if (region[0] == region[1]) {
                    result = Math.max(result, region[0]);
                }
            }
            regionListArr[i][0] = regionResult;
        }
        for (int j = 1; j < matrix[0].length; j++) {
            continuousSize = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == '1') {
                    continuousSize++;
                } else {
                    continuousSize = 0;
                }
                List<int[]> regionList = new ArrayList<>();
                if (continuousSize == 0) {
                    regionListArr[i][j] = regionList;
                    continue;
                }
                for (int k = 0, length = regionListArr[i][j - 1].size(); k <= length; k++) {
                    int[] region = new int[2];
                    boolean quit = false;
                    if (k == length) {
                        region[0] = continuousSize;
                        region[1] = 1;
                    } else {
                        int[] prevRegion = regionListArr[i][j - 1].get(k);
                        if (continuousSize <= prevRegion[0]) {
                            region[0] = continuousSize;
                            region[1] = prevRegion[1] + 1;
                            quit = true;
                        } else {
                            region[0] = prevRegion[0];
                            region[1] = prevRegion[1] + 1;
                        }
                    }
                    if (region[1] < region[0]) {
                        regionList.add(region);
                    } else if (region[1] == region[0]) {
                        result = Math.max(result, region[0]);
                    }
                    if (quit) {
                        break;
                    }
                }
                regionListArr[i][j] = regionList;
            }
        }
        return result * result;
    }
}
