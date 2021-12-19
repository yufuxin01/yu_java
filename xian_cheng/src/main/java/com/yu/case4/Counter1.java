package com.yu.case4;

import java.util.concurrent.atomic.AtomicLong;

public class Counter1 {

    public static AtomicLong inc = new AtomicLong();

    private static void count() throws InterruptedException {
        final Counter1 test = new Counter1();
        Thread th;
        long t1 = System.currentTimeMillis();
        // 这里是1000个线程, 每个线程计数100000 .
        for (int i = 0; i < 1000; i++) {
            th = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    test.increase();
                }
            });
            th.start();
            //计数线程做完之后就调用join操作进行等待.
            th.join();
        }

        long t2 = System.currentTimeMillis();
        System.out.println("Counter1 , " + String.format("结果：%s,耗时(ms)：%s", inc, (t2 - t1)));
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            inc.set(0);
            count();
        }
    }

    public void increase() {
        inc.getAndIncrement();
    }

}
