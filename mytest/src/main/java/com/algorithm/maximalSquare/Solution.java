package com.algorithm.maximalSquare;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int result = 0;
        List<Region>[][] linkedLists = new ArrayList[matrix.length][matrix[0].length];
        int continuousSize = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == '1') {
                continuousSize++;
            } else {
                continuousSize = 0;
            }
            List<Region> regionResult = new ArrayList<>();
            if (continuousSize > 0) {
                Region region = new Region(continuousSize, 1);
                regionResult.add(region);
                if (region.isSqare()) {
                    result = Math.max(result, region.getHeight());
                }
            }
            linkedLists[i][0] = regionResult;
        }
        for (int j = 1; j < matrix[0].length; j++) {
            continuousSize = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == '1') {
                    continuousSize++;
                } else {
                    continuousSize = 0;
                }
                int index = linkedLists[i][j - 1].size() + 1;
                List<Region> regionList = new ArrayList<>();
                if (continuousSize > 0) {
                    if (linkedLists[i][j - 1].size() > 0) {
                        for (int k = linkedLists[i][j - 1].size() - 1; k >= 0; k--) {
                            Region region = linkedLists[i][j - 1].get(k);
                            if (continuousSize <= region.getHeight()) {
                                index--;
                            } else {
                                break;
                            }
                        }
                    }
                    for (int k = 0; k < index; k++) {
                        Region region = null;
                        if (k == linkedLists[i][j - 1].size()) {
                            region = new Region(continuousSize, 1);
                            regionList.add(region);
                        } else {
                            region = new Region(Math.min(linkedLists[i][j - 1].get(k).getHeight(), continuousSize), linkedLists[i][j - 1].get(k).getLength() + 1);
                        }
                        if (region.getLength() > region.getHeight()) {
                        } else if (region.getLength() == region.getHeight()) {
                            result = Math.max(result, region.getHeight());
                        } else {
                            regionList.add(region);
                        }
                    }
                }
                linkedLists[i][j] = regionList;
            }
        }
        return result * result;
    }
}

class Region {
    int height;
    int length;

    public Region(int height, int length) {
        this.height = height;
        this.length = length;
    }

    public int area() {
        return height * length;
    }

    public boolean isSqare() {
        return height == length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}