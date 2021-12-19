package com.yu.case24;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className BigPlate
 * @description：
 * @date 2017/2/16 20:12
 */
public class BigPlate {
    private BlockingQueue<Object> plate = new LinkedBlockingQueue<Object>(10);
    public void putEgg(Object egg) throws InterruptedException {
        plate.put(egg);
        System.out.println("放鸡蛋");
    }
    public Object getEgg() throws InterruptedException {
        Object egg = plate.take();
        System.out.println("拿鸡蛋");
        return egg;
    }
    static class EggAddThread extends Thread {
        private BigPlate plate;
        private Object egg = new Object();
        public EggAddThread(BigPlate plate) {
            this.plate = plate;
        }
        public void run() {
            try {
                plate.putEgg(egg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    static class EggGetThread extends Thread {
        private BigPlate plate;

        public EggGetThread(BigPlate plate) {
            this.plate = plate;
        }

        public void run() {
            try {
                plate.getEgg();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        BigPlate plate = new BigPlate();
        for(int i = 0; i < 20; i++) {
            new Thread(new EggAddThread(plate)).start();
        }
        for(int i = 0; i < 10; i++) {
            new Thread(new EggGetThread(plate)).start();
        }
    }

}
