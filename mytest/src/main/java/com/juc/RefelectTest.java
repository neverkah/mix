package com.juc;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class RefelectTest {


    private int ii;

    float f ;

    double d;

  //  int ii2;

    public static void main(String[] args) throws  Exception {

        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        Field f = RefelectTest.class.getDeclaredField("ii");
        long offset = unsafe.objectFieldOffset(f);

        System.out.println(offset);


    }










}
