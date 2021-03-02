package com.hzj;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) {


        ExecutorService exe = Executors.newFixedThreadPool(3);

        exe.execute(new Runnable() {
            @Override
            public void run() {
              try {
                  Thread.sleep(2000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
                System.out.println("i am awake;");
            }
        });

          exe.shutdown();


        System.out.println(" i am the main thread");
    }

@org.junit.Test
    public void test(){
        ExecutorService exe = Executors.newFixedThreadPool(3);

      exe.execute(new Runnable() {
          @Override
          public void run() {
              try {
                  Thread.sleep(2000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.println("i am awake;");
          }
      });

     //   exe.shutdown();


        System.out.println(" i am the main thread");
    }
}
