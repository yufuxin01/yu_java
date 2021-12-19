package com.alonginfo;

/**
 * @author yufuxin
 * @version 1.0
 * @date 2020/12/17 18:59
 */
public class TestThread1 implements Runnable{

    int ticketNum = 10;

    @Override
    public void run() {
        while (true){
            if (ticketNum<=0){
                break;
            }

            System.out.println(Thread.currentThread().getName()+"====>拿到了第"+ticketNum--+"票");
        }
    }

    public static void main(String[] args) {
        TestThread1 ticket = new TestThread1();
        new Thread(ticket,"小于").start();
        new Thread(ticket,"嚣张").start();
        new Thread(ticket,"黄牛").start();
    }

}
