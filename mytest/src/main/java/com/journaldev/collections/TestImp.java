package com.journaldev.collections;

import java.sql.SQLOutput;

public class TestImp implements TestInterfaceA,TestInterfaceB {


    public static void main(String[] args) {


        TestInterfaceB testImp= new TestImp();


        TestInterfaceB b = (TestInterfaceB) testImp;
        TestInterfaceA a= (TestInterfaceA) testImp;

        System.out.println(a);
        System.out.println(b);
    }
}
