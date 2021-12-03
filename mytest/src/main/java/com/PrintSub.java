package com;

public class PrintSub {

    public static void print(String s) {

        for (int i = 1; i <= s.length(); i++) { // 表示子串的长度
            for (int j = 0; j <= s.length() - i; j++) {
                printArray(s, j, j + i-1);
            }
        }
    }

    private static void printArray(String s, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            System.out.print(s.charAt(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {

        print("HUANGZHONGJIE");
    }
}
