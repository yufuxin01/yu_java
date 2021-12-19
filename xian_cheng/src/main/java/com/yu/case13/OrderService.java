package com.yu.case13;

import java.util.concurrent.*;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className OrderService
 * @description：
 * @date 2017/12/31 11:28
 */
public class OrderService {

    public static int createSyncOrder(){
        boolean flag1= CheckService1.check();
        boolean flag2=CheckService2.check();
        boolean flag3=CheckService3.check();
       if(true==flag1&&true==flag2&&true==flag3){
           createOrder();
           return 1;
       }
       return  0;
    }

    public static int createParrelOrder() throws Exception {
        int threadCount=3;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        CheckService1Callable  call1=new CheckService1Callable();
        Future<Boolean> future1 =executor.submit(call1);
        CheckService2Callable  call2=new CheckService2Callable();
        Future<Boolean> future2 =executor.submit(call2);
        CheckService3Callable  call3=new CheckService3Callable();
        Future<Boolean> future3=executor.submit(call3);
        // 如果三个都返回true才接着在,否则就不走了.
        if(true==future1.get()&&true==future2.get()&&true==future3.get()){
            System.out.println("true==future1.get()&&true==future2.get()&&true==future3.get()");
            createOrder();
         return  1;
        }
        executor.shutdown();
        return 0;
    }

     public static void createOrder(){
         try {
             //模拟生成订单的逻辑
             Thread.sleep(500);
             System.out.println("==finally，create Order==");
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }

}
