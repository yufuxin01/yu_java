package com.yu.case20;

import java.util.concurrent.Semaphore;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className TestSemaphore
 * @description：
 * @date 2017/1/29 11:35
 */
public class TestSemaphore {
    public static void main(String[] args){
        test();
    }

    public static void  test() {
        Semaphore semaphore= new Semaphore(5);
        for(int i=0;i<20;i++){
            new Thread(new Runnable() {
                @Override
				public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+" 开始运行时间 : "+System.currentTimeMillis());
                        Thread.sleep(5000);
                        System.out.println(Thread.currentThread().getName()+" 结束运行时间 : "+System.currentTimeMillis());
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }


    }


}
