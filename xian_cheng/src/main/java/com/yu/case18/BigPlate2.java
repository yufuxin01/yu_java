package com.yu.case18;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/**
 */
public class BigPlate2 {
    private BlockingQueue<Object> plate = new LinkedBlockingQueue<Object>(10);
    public void putEgg(Object egg) {
        plate.add(egg);
        System.out.println("放鸡蛋");
    }
    public Object getEgg() {
        Object egg = null;
        egg = plate.remove();
        System.out.println("拿鸡蛋");
        return egg;
    }
    static class EggAddThread extends Thread {
        private BigPlate2 plate;
        private Object egg = new Object();
        public EggAddThread(BigPlate2 plate) {
            this.plate = plate;
        }
        public void run() {
            plate.putEgg(egg);
        }
    }
    static class EggGetThread extends Thread {
        private BigPlate2 plate;
        public EggGetThread(BigPlate2 plate) {
            this.plate = plate;
        }
        public void run() {
            plate.getEgg();
        }
    }

    public static void main(String[] args) {
        BigPlate2 plate = new BigPlate2();
        for(int i = 0; i < 20; i++) {
            new Thread(new EggAddThread(plate)).start();
        }
        for(int i = 0; i < 10; i++) {
            new Thread(new EggGetThread(plate)).start();
        }
    }

}
