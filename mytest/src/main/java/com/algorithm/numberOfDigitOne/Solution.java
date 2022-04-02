package com.algorithm.numberOfDigitOne;

class Solution {
    //  digitOne[i]表示0-位数为i的最大的数字 出现的1的次数  即countDigitOne(9),countDigitOne(99)...
    int[] digitOne = new int[]{0, 1, 20, 300, 4000, 50000, 600000, 7000000, 80000000, 900000000};

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.countDigitOne2(10));
        for (int i = 0; i <= 1000000000; i++) {
            System.out.println(solution.countDigitOne2(i));
//            if (solution.countDigitOne(i) != solution.countDigitOne2(i)) {
//                System.out.println(i);
//                break;
//            }
        }

    }

    public int countDigitOne2(int n) {
        long[] pow = new long[11];
        pow[0] = 1;
        for (int i = 1; i < pow.length; i++) {
            pow[i] = pow[i - 1] * 10;
        }
        int[] nums = new int[10];
        int t = n;
        int N = 0;
        for (N = 0; t > 0; N++) {
            nums[N] = t % 10;
            t /= 10;
        }
        int res = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                res += (n / pow[i + 1] ) * pow[i];
            } else if (nums[i] == 1) {
                res += (n / pow[i + 1]) * pow[i];
                res += n % pow[i] + 1;
            } else {
                res += (n / pow[i + 1] + 1) * pow[i];
            }
        }
        return res;
    }

    /**
     * 从右往左按位依次计算
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int digitOneNum = 0;  // 289 计算到第三位2的时候 digitOneNum=countDigitOne(89)
        int tail = n % 10;  // 计算到n位时，n-1到1位的数字   289  计算到第三位2的时候 tail=89
        int temp = n;  // 放除以10的结果，用来从低位到高位取数
        int digit = 0;// 从右往左数，第几位数字  289  9属于第1位 8属于第二位 2属于第三位
        int pow = 1;// 10的n次方 变量
        while (temp > 0) {
            int head = temp % 10;
            temp = temp / 10;
            digit++;
            if (digit == 1) {
                digitOneNum = head == 0 ? 0 : 1;
            } else {
                pow *= 10;
                if (head == 0) {
                    continue;
                } else if (head == 1) {
                    digitOneNum = digitOne[digit - 1] + (tail + 1) + digitOneNum;
                } else {
                    digitOneNum = head * digitOne[digit - 1] + pow + digitOneNum;
                }
            }
            tail = n % (pow * 10);
        }
        return digitOneNum;
    }
}