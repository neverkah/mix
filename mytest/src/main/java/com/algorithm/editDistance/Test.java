package com.algorithm.editDistance;

import java.util.Random;

public class Test {

    // 0 <= word1.length, word2.length <= 500

    // [0,501)

    public static void main(String[] args) {
        Random random = new Random();

        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();

        for (int t = 0; t < 100000; t++) {


            int length1 = random.nextInt(501);

            String word1 = "";
            for (int i = 0; i < length1; i++) {

                word1 += (char) (random.nextInt(26) + 97);

            }

            int length2 = random.nextInt(501);

            String word2 = "";
            for (int i = 0; i < length2; i++) {
                word2 += (char) (random.nextInt(26) + 97);
            }

            if (solution.minDistance(word1, word2) != solution2.minDistance(word1, word2)) {
                System.out.println(word1);
                System.out.println(word2);
            }

        }
    }
}
