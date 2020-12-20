package com.hzj;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) {


        ExecutorService executorService = Executors.newCachedThreadPool();


        final Semaphore semaphore = new Semaphore(5);
        for(int i =0;i<20;i++){


            final  int no = i;


            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();

                        System.out.println("Accessing: " + no);

                        Thread.sleep(10000);

                        semaphore.release();

                        System.out.println("*" + semaphore.availablePermits());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };

            executorService.execute(run);
        }

        executorService.shutdown();

    }
}
