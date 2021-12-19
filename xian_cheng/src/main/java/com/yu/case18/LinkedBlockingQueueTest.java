package com.yu.case18;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className LinkedBlockingQueueTest
 * @description：
 * @date 2017/1/31 16:09
 */
public class LinkedBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> queue1=new LinkedBlockingQueue(3);
        boolean bol1=queue1.offer("hello1");
        boolean bol2=queue1.offer("world2");
        boolean bol3=queue1.offer("sky3");
        boolean bol4=queue1.offer("result4");
        System.out.println(queue1.toString());
        System.out.println("bol1 is "+bol1+",bol2 is :"+bol2+",bol3 is :"+bol3+",bol4 is :"+bol4);
        while(!queue1.isEmpty()) {
            System.out.println(queue1.poll());
        }

    }
}
