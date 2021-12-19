package com.yu.case8;

import java.util.concurrent.CountDownLatch;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className OrderThread1
 * @description：
 * @date 2017/12/23 20:23
 */
public class OrderThread1 extends Thread {

    private CountDownLatch latch;

    public OrderThread1(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        System.out.println("Thread:" + Thread.currentThread().getName() + " is running");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread:" + Thread.currentThread().getName() + " is end");
        latch.countDown();
    }
}
