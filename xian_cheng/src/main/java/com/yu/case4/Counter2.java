package com.yu.case4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter2 {

    public static int inc = 0;
    Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            inc = 0;
            count();
        }
    }

    private static void count() throws InterruptedException {
        final Counter2 test = new Counter2();
        Thread th;
        long t1 = System.currentTimeMillis();
        //1000 个线程, 每个线程计算100000
        for (int i = 0; i < 1000; i++) {
            th = new Thread(() -> {
                for (int j = 0; j < 100000; j++)
                    test.increase();
            });
            th.start();
            //线程等待
            th.join();
        }

        long t2 = System.currentTimeMillis();
        System.out.println("Counter2 , " + String.format("结果：%s,耗时(ms)：%s", test.inc, (t2 - t1)));
    }

    public void increase() {
        // 加锁
        lock.lock();
        try {
            // 由于这个inc不是线程安全的,所以为了保证线程安全问题,累加的时候需要加锁,加完了之后再释放锁.
            //这种方式不如原子类的性能高
            inc++;
        } finally {
            //释放锁
            lock.unlock();
        }
    }
}
