package com.yu.case4;

import java.util.concurrent.atomic.LongAdder;

public class Counter10 {

    public static LongAdder inc = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            inc.reset();
            count();
        }

    }

    private static void count() throws InterruptedException {
        final Counter10 test = new Counter10();
        Thread th;
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            th = new Thread(() -> {
                for (int j = 0; j < 100000; j++)
                    test.increase();
            });
            th.start();
            th.join();
        }

        long t2 = System.currentTimeMillis();
        System.out.println("Counter10 , " + String.format("结果：%s,耗时(ms)：%s", test.inc, (t2 - t1)));
    }

    public void increase() {
        inc.increment();
    }

}
