package com.algorithm.numberOfDigitOne;

class Solution {
    //  digitOne[i]表示0-位数为i的最大的数字 出现的1的次数  即countDigitOne(9),countDigitOne(99)...
    int[] digitOne = new int[]{0, 1, 20, 300, 4000, 50000, 600000, 7000000, 80000000, 900000000};

    public static void main(String[] args) {
        System.out.println(new Solution().countDigitOne(23));
    }

    /**
     * 从右往左按位依次计算
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int lowNumberDigitOne = 0;  // 289 计算到第三位2的时候 lowNumberDigitOne=countDigitOne(89)
        int lowNumber = 0;  // 计算到n位时，n-1到1位的数字   289  计算到第三位2的时候 lowNumber=89
        boolean allNine = true; // 是否全部是9
        int temp = n;  // 放除以10的结果，用来从低位到高位取数
        int digit = 0;// 从右往左数，第几位数字  289  9属于第1位 8属于第二位 2属于第三位
        int pow = 1;// 10的n次方 变量
        while (temp > 0) {
            int number = temp % 10;
            temp = temp / 10;
            if (number != 9) {
                allNine = false;
            }
            digit++;
            pow = pow * 10;
            if (allNine) {
                lowNumberDigitOne = digitOne[digit];
                lowNumber = n % pow;
                continue;
            }
            if (digit == 1) {
                lowNumberDigitOne = number == 0 ? 0 : 1;
            } else {
                if (number == 0) {
                    continue;
                } else if (number == 1) {
                    lowNumberDigitOne = digitOne[digit - 1] + (lowNumber + 1) + lowNumberDigitOne;
                } else {
                    lowNumberDigitOne = number * digitOne[digit - 1] + pow / 10 + lowNumberDigitOne;
                }
            }
            lowNumber = n % pow;
        }
        return lowNumberDigitOne;
    }
}