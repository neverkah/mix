package com.algorithm.multiplyStrings;

    class Solution {
        char ZERO = '0';
        String ZEROSTR = "0";

        public String multiply(String num1, String num2) {
            if (ZEROSTR.equals(num1) || ZEROSTR.equals(num2)) {
                return ZEROSTR;
            }
            int[] res = new int[num1.length() + num2.length()];
            int beginIndex = res.length - 1; // res数组开始计算的位置 从后往前计算
            for (int j = num2.length() - 1; j >= 0; j--) {
                int carry = 0; // 进位
                int resIndex = beginIndex;
                for (int i = num1.length() - 1; i >= 0; i--) {
                    int bitMul = (num1.charAt(i) - ZERO) * (num2.charAt(j) - ZERO);
                    int bitAdd = bitMul % 10 + carry + res[resIndex];
                    carry = bitMul / 10 + bitAdd / 10;
                    res[resIndex] = bitAdd % 10;
                    resIndex--;
                }
                if (carry > 0) {
                    res[resIndex] = carry;
                }
                beginIndex--;
            }
            int index = res[0] == 0 ? 1 : 0;
            StringBuffer ans = new StringBuffer();
            while (index < res.length) {
                ans.append(res[index]);
                index++;
            }
            return ans.toString();
        }
    }