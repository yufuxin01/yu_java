package com.alonginfo;

/**
 * @ClassName Demo1
 * @Description: TODO
 * @Author Lenovo
 * @Date 2021/12/17
 * @Version V1.0
 **/
public class CountDown implements Runnable {
    protected int countDown = 5;
    private static int myId = 0;
    private final int taskId = myId++;

    public CountDown() {
        super();
    }


    public CountDown(int countDown) {
        super();
        this.countDown = countDown;
    }

    public String status() {
        return "＃" + taskId + "#(" + (countDown > 0 ? countDown : "Over") + "),  " + Thread.currentThread().getName();
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }
    
}