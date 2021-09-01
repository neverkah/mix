package com.juc;

import java.lang.reflect.Field;
import java.nio.ByteOrder;
import sun.misc.Unsafe;

public class Test2 {


    public static void main(String[] args) throws  Exception {

        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        long a = unsafe.allocateMemory(8);
        try {
            unsafe.putLong(a, 0x0102030405060708L);
            //存放此long类型数据，实际存放占8个字节，01,02,03，04,05,06,07,08
            byte b = unsafe.getByte(a);
            System.out.println(b);
            //通过getByte方法获取刚才存放的long，取第一个字节
            //如果是大端，long类型顺序存放—》01,02,03,04,05,06,07,08  ，取第一位便是0x01
            //如果是小端，long类型顺序存放—》08,07,06,05,04,03,02,01                                                                         ，取第一位便是0x08
            switch (b) {
                case 0x01:
                    ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
                    break;
                case 0x08:
                    byteOrder = ByteOrder.LITTLE_ENDIAN;
                    break;
                default:
                    assert false;
                    byteOrder = null;

                    System.out.println(byteOrder);
            }
        }catch (Exception e){

        }

    }
}
