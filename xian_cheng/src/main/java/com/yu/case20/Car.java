package com.yu.case20;

import java.util.concurrent.Semaphore;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className Test
 * @description：
 * @date 2017/12/20 17:06
 */
public class Car {

    public static void main(String[] args) {
        park();
    }

    private static void park() {
        Semaphore semaphore = new Semaphore(8);

        for (int i = 1; i < 51; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("车辆"+Thread.currentThread().getName() + " 停车并加油" );
                        Thread.sleep(6000);
                        System.out.println("车辆"+Thread.currentThread().getName() + " 停车、加油6秒后离开 ");

                    } catch (Exception e){
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                    }
                }
            },String.valueOf(i)).start();
        }
    }


}
