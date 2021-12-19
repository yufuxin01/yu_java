package com.yu.case14;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className Test
 * @description：
 * @date 2017/12/27 14:00
 */
public class Test {

    public static void main(String[] args) {
    	// 同步调用
        long start1 = System.currentTimeMillis();
        PaymentService.syncPay();
        System.out.println("同步支付耗时:" + (System.currentTimeMillis() - start1)+" ms");
        System.out.println("=========================");
        // 异步调用
        long start2 = System.currentTimeMillis();
        PaymentService.asyncPay();
        System.out.println("异步支付耗时:" + (System.currentTimeMillis() - start2)+" ms");
    }

}
