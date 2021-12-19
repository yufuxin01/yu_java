package com.yu.case23;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className Worker
 * @description：
 * @date 2017/2/1 20:20
 */
public class Worker implements Runnable{
    private ConcurrentLinkedQueue<Product> workQueue;
    private ConcurrentHashMap<String, Object> resultMap;

    public void setWorkQueue(ConcurrentLinkedQueue<Product> workQueue) {
        this.workQueue = workQueue;
    }

    public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public void run() {
        while(true){
            Product input = this.workQueue.poll();
            if(input == null) break;
            Object output = handle(input);
            System.out.println("线程 "+Thread.currentThread().getName()+" , 计算完毕"+ input);
            this.resultMap.put(Integer.toString(input.getPrdId()), output);
        }
    }

    private Object handle(Product input) {
        Object output = null;
        try {
            //模拟耗时的操作
            Thread.sleep(100);
            output = input.getPrdPrice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return output;
    }


}
