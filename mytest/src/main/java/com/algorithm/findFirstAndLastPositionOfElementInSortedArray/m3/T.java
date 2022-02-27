package com.algorithm.findFirstAndLastPositionOfElementInSortedArray.m3;



import org.junit.Test;

import java.util.Arrays;

public class T {


    @Test
   public    void test1(){
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        for (int i : new Solution().searchRange(nums, target)) {
            System.out.println(i);
        }
    }
}
