package com.yu.case24;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className LinkedBlockingQueueTest
 * @description：
 * @date 2017/1/31 16:09
 */
public class LinkedBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> queue=new LinkedBlockingQueue();
        boolean bol1=queue.offer("hello1");
        boolean bol2=queue.offer("world2");
        boolean bol3=queue.offer("yes3");
        System.out.println(queue.toString());
        System.out.println("bol1 is "+bol1+",bol2 is :"+bol2+",bol3 is :"+bol3);
        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
