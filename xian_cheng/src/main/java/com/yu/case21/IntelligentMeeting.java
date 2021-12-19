package com.yu.case21;
import java.util.concurrent.CountDownLatch;


public class IntelligentMeeting implements Runnable {

    private final CountDownLatch register;

    public IntelligentMeeting(int number) {
        register = new CountDownLatch(number);
    }


    public void arrive(String name) {
        System.out.printf("%s已经到会.\n", name);
        register.countDown();
        System.out.printf("智能会议系统:等待%d名还未参会人员.\n", register.getCount());
    }

    /**
     * 核心方法，当所有参与者都到达了，才开始开会
     */
    @Override
    public void run() {
        System.out.printf("智能会议系统:总共有%d名参会人员.\n", register.getCount());
        try {
            // 等待与会人员
            register.await();
            //开始会议
            System.out.printf("智能会议系统:所有人已经到齐\n");
            System.out.printf("智能会议系统:让我们一起开会吧\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
