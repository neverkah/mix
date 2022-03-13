package com.nowcoder.localMin;

import org.junit.Test;

import java.util.Random;

public class T {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {8, 7, 3, 3, 4};
        int x = solution.getLessIndex(nums);
        int x2 = solution.getLessIndex2(nums);
        System.out.println(x);
        System.out.println(x2);

    }

    @Test
    public void test1() {

        int N = 5;

        Random r = new Random();
        Solution solution = new Solution();
        while (true) {


            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                if (i == 0) {
                    nums[i] = r.nextInt(20) + 1;
                } else {
                    nums[i] = r.nextInt(20) + 1;
                    while (nums[i] == nums[i - 1]) {
                        nums[i] = r.nextInt(20) + 1;
                    }
                }

            }

            if (solution.getLessIndex(nums) != solution.getLessIndex2(nums)) {
                System.out.println("error");
                break;
            }

        }
    }
}
