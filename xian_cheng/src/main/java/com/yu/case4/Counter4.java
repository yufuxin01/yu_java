package com.yu.case4;

import java.util.concurrent.atomic.AtomicLong;

public class Counter4 {

    public static AtomicLong inc = new AtomicLong();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            inc.set(0);
            count();
        }
    }

    private static void count() throws InterruptedException {
        final Counter4 test = new Counter4();
        long t1 = System.currentTimeMillis();
        Thread th = null;
        for (int i = 0; i < 1000; i++) {
            th = new Thread() {
                public void run() {
                    for (int j = 0; j < 100000; j++)
                        test.increase();
                }

                ;
            };
            th.start();
            // 线程内部状态类,如果线程不是完成状态,那么就继续等待
            while (th.getState() != Thread.State.TERMINATED) {
                Thread.sleep(1);
            }
        }

        long t2 = System.currentTimeMillis();
        System.out.println("Counter4, " + String.format("结果：%s,耗时(ms)：%s", test.inc, (t2 - t1)));
    }

    public void increase() {
        inc.getAndIncrement();
    }

}
