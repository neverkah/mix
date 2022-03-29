package com.algorithm.numbersWithRepeatedDigits;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class T {
    public static void main(String[] args) {
        int x = 1000000000;

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        Integer[] integers = new Integer[2];

        list.toArray(integers);

        for (Integer i : integers) {
            System.out.println(i);
        }
    }

    @Test
    public void test() {

        int n = 110;


//       System.out.println(new Solution2().numDupDigitsAtMostN(n));

        for (int i = 1; i <= 1000000; i++) {
            if (new Solution().numDupDigitsAtMostN(i) > new Solution3().numDupDigitsAtMostN(i)) {
                System.out.println(i);
                break;
            }
        }


    }
}
