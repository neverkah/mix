package com.hzj;

public class CounterDemo {
    public final int limit = 100; // 时间窗口内最大请求数
    public final long interval = 1000; // 时间窗口ms
    public long timeStamp = getNowTime();
    public int reqCount = 0;

    private long getNowTime() {
        return System.currentTimeMillis();
    }

    public boolean grant() {
        long now = getNowTime();
        if (now < timeStamp + interval) {
// 在时间窗口内
            reqCount++;
// 判断当前时间窗口内是否超过最大请求控制数
            return reqCount <= limit;
        } else {
            timeStamp = now;
// 超时后重置
            reqCount = 1;
            return true;
        }
    }
}