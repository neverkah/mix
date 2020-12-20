package com.hzj;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class RateLimiterTest {


    @Test
    public void test2(){
        RateLimiter limiter = RateLimiter.create(5);
        System.out.println(limiter.acquire(10));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
    }


    @Test
    public void test1() throws InterruptedException {

        RateLimiter limiter = RateLimiter.create(5, 88, TimeUnit.MILLISECONDS);
        for(int i = 1; i < 5;i++) {
            System.out.println(limiter.acquire());
        }
        Thread.sleep(1000L);
        for(int i = 1; i < 5;i++) {
            System.out.println(limiter.acquire());
        }
    }
}
