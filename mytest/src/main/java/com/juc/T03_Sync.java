package com.juc;

import org.openjdk.jol.info.ClassLayout;

public class T03_Sync {

    public static void main(String[] args) throws  Exception {
        {
            Thread.sleep(5000);
            Person p1 = new Person("zhangsan",3);

            Person p2 = new Person("lisi",7);

//        System.out.println(p1.hashCode() == p2.hashCode());
//        System.out.println(p1.hashCode() == p2.hashCode());

//        synchronized (p1) {
//            System.out.println(ClassLayout.parseInstance(p1).toPrintable());
//        }
            synchronized (p1){
                System.out.println(ClassLayout.parseInstance(p1).toPrintable());
            }





        }


    }
}
