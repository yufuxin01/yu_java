package com.yu.case14;

import java.util.concurrent.TimeUnit;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className CheckService
 * @description：
 * @date 2017/12/27 10:58
 */
public class CheckService {
	/**
	 * 返回true说明订单流程才会往下走
	 */
    public static boolean isValid() {
        System.out.println("订单生成前，检验订单是否合法" );
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //假设订单合法，通过校验
        return true;
    }
}
