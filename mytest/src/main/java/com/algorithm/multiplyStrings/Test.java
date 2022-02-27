package com.algorithm.multiplyStrings;

import java.math.BigInteger;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Random r = new Random();

        Solution solution = new Solution();

        while (true) {
            int length1 = r.nextInt(4);
            int length2 = r.nextInt(4);

            String s1 = "", s2 = "";
            for (int i = 0; i < length1; i++) {
                int x = r.nextInt(10);


                s1 += (char) (x + 48);
            }
            for (int i = 0; i < length2; i++) {
                int x = r.nextInt(10);

                s2 += (char) (x + 48);
            }

            int begin = 0;
            for (int i = 0; i < length1; i++) {
                if (s1.charAt(i) != '0') {
                    begin = i;
                    break;
                }
            }
            s1 = s1.substring(begin);
            begin = 0;
            for (int i = 0; i < length2; i++) {
                if (s2.charAt(i) != '0') {
                    begin = i;
                    break;
                }
            }

            s2 = s2.substring(begin);

            if (s1.length() == 0 || s2.length() == 0) {
                continue;
            }


            try {


                BigInteger b1 = new BigInteger(s1).multiply(new BigInteger(s2));
                BigInteger b2 = new BigInteger(solution.multiply(s1, s2));

                if (!b1.equals(b2)) {
                    System.out.println("error");
                    System.out.println(s1 + "  " + s2);
                }


            } catch (Exception e) {

                e.printStackTrace();
                System.out.println("exception");
                System.out.println(s1 + "  " + s2);
            }

        }
    }

    @org.junit.Test
    public void test() {

        Solution solution = new Solution();
        String s1 = "4", s2 = "28";
        System.out.println(solution.multiply(s1, s2));
        System.out.println(new BigInteger(s1).multiply(new BigInteger(s2)));

    }
}
