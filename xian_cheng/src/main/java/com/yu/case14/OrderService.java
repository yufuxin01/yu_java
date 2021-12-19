package com.yu.case14;

import java.util.concurrent.TimeUnit;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className OrderService
 * @description：
 * @date 2017/12/27 10:58
 */
public class OrderService {

    public static int createOrder() {
        int orderSum=1;
        System.out.println("生成订单" );
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //假设订单数量为1
        return orderSum;
    }

}
