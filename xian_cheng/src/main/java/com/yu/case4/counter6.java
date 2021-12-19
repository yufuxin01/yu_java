package com.yu.case4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

public class counter6 {

    static int count = 0;

    public static synchronized void incr() {
        count++;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int i = 0; i < 10; i++) {
            count = 0;
            count();
        }
    }

    private static void count() throws InterruptedException {
        long t1 = System.currentTimeMillis();
        //1000个计数器
        int threadCount = 1000;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < 100000; j++) {
                        incr();
                    }
                } finally {
                    // 递减锁存计数
                    countDownLatch.countDown();
                }
            }).start();
        }
        //等待
        countDownLatch.await();
        long t2 = System.currentTimeMillis();
        System.out.println("Counter6, " + String.format("结果：%s,耗时(ms)：%s", count, (t2 - t1)));
    }

}
