package com.juc;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

public class T01_Sync1 {
  

    public static void main(String[] args) {
        Object o = new Object();


        RefelectTest[] refelectTestArr = new RefelectTest[128];
        boolean b = o.equals(new Object());
        System.out.println(b);
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }


    @Test
    public  void test1() throws  Exception{
        Thread.sleep(5000);
        final Person p1 = new Person("zhangsan",3);

        Person p2 = new Person("lisi",7);

//        System.out.println(p1.hashCode() == p2.hashCode());
//        System.out.println(p1.hashCode() == p2.hashCode());

//        synchronized (p1) {
//            System.out.println(ClassLayout.parseInstance(p1).toPrintable());
//        }


        Thread t  = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(ClassLayout.parseInstance(p1).toPrintable());
            }
        });

        t.start();


        Thread.sleep(5000);


    }
}