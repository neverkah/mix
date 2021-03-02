
package com.sunline.test;
import java.util.Random;
/**
 * @Description: ThreadLocal类实现线程范围内数据共享
 * @author huangzjb cblue2013@126.com
 * @Company Digital China
 * @date 2014-5-28 下午08:42:21
 * @version 1.0
 */
public class ThreadLocalTest3 {
    //private static ThreadLocal<MyThreadScopeData1> myThreadScopeData = new ThreadLocal<MyThreadScopeData1>();
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                public void run() {
                    int data = new Random().nextInt();
                    MyThreadScopeData myThreadScopeData = MyThreadScopeData
                            .getThreadIntance();
                    myThreadScopeData.setAge(data);
                    myThreadScopeData.setName("name " + data);
                    System.out.println(Thread.currentThread().getName()
                            + " has put data : " + data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A {
        public void get() {
            MyThreadScopeData mydata = MyThreadScopeData.getThreadIntance();
            System.out.println("A from  " + Thread.currentThread().getName()
                    + " get data : name " + mydata.getName() + " :age "
                    + mydata.getAge());
        }
    }

    static class B {
        public void get() {
            MyThreadScopeData mydata = MyThreadScopeData.getThreadIntance();
            System.out.println("B from  " + Thread.currentThread().getName()
                    + " get data : " + mydata.getName() + " :age "
                    + mydata.getAge());
        }
    }
}


/**
 * @Description: 每个线程产生与该线程绑定的唯一一个对象
 * @author huangzjb cblue2013@126.com
 * @Company Digital China
 * @date 2014-5-30 下午08:39:49
 * @version 1.0
 */

class MyThreadScopeData {
    private MyThreadScopeData() {
    }
    public static MyThreadScopeData getThreadIntance() {
        MyThreadScopeData instance = map.get();
        if (instance == null) {
            instance = new MyThreadScopeData();
            map.set(instance);
        }
        return instance;
    }

    private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<MyThreadScopeData>();
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

