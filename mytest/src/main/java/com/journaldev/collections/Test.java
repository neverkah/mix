package com.journaldev.collections;

public class Test {

    public static void main(String[] args) {

       int i  = 65535;
       int numOfBit = 0;
       while(i>0){
           i = i<<1;
           numOfBit++;
       }

        System.out.println(numOfBit);

    }
}
