package com.algorithm.containsDuplicateIii.m2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        List<Num> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numList.add(new Num(i, nums[i]));
        }
        Collections.sort(numList);
        for (int i = 0; i < numList.size() - 1; i++) {
            for (int j = i + 1; j < numList.size(); j++) {
                Num num = numList.get(i);
                Num nearNum = numList.get(j);
                if (nearNum.getV() - num.getV() > valueDiff) {
                    break;
                }
                if (nearNum.getV() - num.getV() <= valueDiff && Math.abs(nearNum.getIndex() - num.getIndex()) <= indexDiff) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Num implements Comparable<Num> {
    int index;
    int v;

    public Num(int index, int v) {
        this.v = v;
        this.index = index;
    }

    public int getV() {
        return v;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(Num o) {
        return v - o.getV();
    }
}
