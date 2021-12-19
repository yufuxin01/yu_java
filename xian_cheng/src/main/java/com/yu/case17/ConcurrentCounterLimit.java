package com.yu.case17;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className ConcurrentCounterLimit
 * @description：
 * @date 2017/1/29 17:08
 */
public class ConcurrentCounterLimit {

    // 限流的个数
    private static int maxCount = 10;
    // 指定的时间内
    private static int interval = 10;
    // 原子类计数器
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    // 起始时间
    private long startTime = System.currentTimeMillis();

    public boolean limit(int maxCount, int interval) {
        atomicInteger.addAndGet(1);
        System.out.println("atomicInteger   value is  : "+atomicInteger.get());
        // 超过了间隔时间，直接重新开始计数
        if (System.currentTimeMillis() - startTime > interval * 1000) {
            startTime = System.currentTimeMillis();
            atomicInteger.set(1);
            return true;
        }
        // 还在间隔时间内,check有没有超过限流的个数
        if ((atomicInteger.get()) ==maxCount) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        ConcurrentCounterLimit limiter=new ConcurrentCounterLimit();
        boolean flag;
      for(int i=0;i<60;i++){
          flag= limiter.limit(maxCount,interval);
          if(false==flag){
              System.out.println("超过流量限制，限流了");
              Thread.sleep(2000);
              atomicInteger.set(0);
          }
     }
    }

}
