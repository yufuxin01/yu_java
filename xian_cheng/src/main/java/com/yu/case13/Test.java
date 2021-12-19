package com.yu.case13;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className Test
 * @description：
 * @date 2017/12/31 11:28
 */
public class Test {

    public static void main(String[] args) throws Exception {
    	// 串行调用
        long t1=System.currentTimeMillis();
        System.out.println("begin to excute createSyncOrder");
        OrderService.createSyncOrder();
        System.out.println("end createSyncOrder , it has spent "+ (System.currentTimeMillis()-t1)+" ms");
        System.out.println("===========================================");
        // 并行调用
        long t2=System.currentTimeMillis();
        System.out.println("begin to excute createParrelOrder");
        OrderService.createParrelOrder();
        System.out.println("end createParrelOrder, it has spent "+ (System.currentTimeMillis()-t2)+" ms");
    }

}
