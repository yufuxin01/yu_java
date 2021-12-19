package com.yu.case3;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className DeadLockTest
 * @description：
 * @date 2017/11/21 15:34
 */
public class DeadLockTest extends Thread {

    private String first;
    private String second;
    public DeadLockTest(String name, String first, String second) {
        super(name);
        this.first = first;
        this.second = second;
    }

    public  void run() {
        synchronized (first) {
            try {
                System.out.println(this.getName() + " ...synchronized:===> 【first】" + first);
                Thread.sleep(1000L);
                synchronized (second) {
                    System.out.println(this.getName() + " ...synchronized:===>【second】 " + second);
                }
            } catch (InterruptedException e) {}
        }
    }
    public static void main(String[] args) throws InterruptedException {
        String lockA = "lockA";
        String lockB = "lockB";
        DeadLockTest t1 = new DeadLockTest("t1", lockA, lockB);
        DeadLockTest t2 = new DeadLockTest("t2", lockB, lockA);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }


}
