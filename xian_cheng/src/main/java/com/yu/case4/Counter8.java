package com.yu.case4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.LongAdder;


public class Counter8 {
    static LongAdder count = new LongAdder();

    public static void incr() {
        count.increment();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int i = 0; i < 10; i++) {
            count.reset();
            m1();
        }
    }

    private static void m1() throws ExecutionException, InterruptedException {
        long t1 = System.currentTimeMillis();
        int threadCount = 1000;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < 100000; j++) {
                        incr();
                    }
                } finally {
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        long t2 = System.currentTimeMillis();
        System.out.println("Counter8, " + String.format("结果：%s,耗时(ms)：%s", count.sum(), (t2 - t1)));
    }


}
