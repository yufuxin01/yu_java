package com.yu.case3;

/**
 * @author huanglaoxie(微信 : yfct - 8888)
 * @className DeadLock
 * @description：
 * @date 2017/11/18 16:06
 */
public class DeadLock extends Thread {

    static Object fork1 = new Object();
    static Object fork2 = new Object();
    protected Object tool;

    public DeadLock(Object object) {
        this.tool = object;

        if (tool == fork1) {
            this.setName("哲学家A");
        }
        if (tool == fork2) {
            this.setName("哲学家B");
        }
    }

    public static void main(String args[]) throws InterruptedException {
//        DeadLock 哲学家A = new DeadLock(fork1);
//        DeadLock 哲学家B = new DeadLock(fork2);
//
//        哲学家A.start();
//        哲学家B.start();

        Thread.sleep(1000);
    }

    public void run() {
        if (tool == fork1) {
            synchronized (fork1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (fork2) {
                    System.out.println("哲学家A开始吃饭了");
                }
            }
        }
        if (tool == fork2) {
            synchronized (fork2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (fork1) {
                    System.out.println("哲学家B开始吃饭了");
                }
            }
        }
    }
}
