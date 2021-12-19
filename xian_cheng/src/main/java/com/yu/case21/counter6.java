package com.yu.case21;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className Demo1
 * @description：
 * @date 2017/12/19 10:58
 */
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
        System.out.println("Counter6, "+String.format("结果：%s,耗时(ms)：%s", count, (t2 - t1)));
    }

}
