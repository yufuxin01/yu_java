package com.yu.case8;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className OrderThread2
 * @description：
 * @date 2017/12/23 20:27
 */
public class OrderThread2 extends Thread{

    @Override
	public void run(){
        System.out.println("Thread:"+Thread.currentThread().getName()+" is running");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread:"+Thread.currentThread().getName()+" is end");
    }
}