package com.yu.case7;

import java.util.concurrent.Callable;
/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className PrizeThread
 * @description：
 * @date 2017/11/25 12:06
 */
public class PrizeThread implements Callable<String> {
    Object prize =new Object();
    boolean flag = false;

    @Override
	public String call() throws Exception {
        Thread.sleep(1000);
        synchronized (prize) {
            if(flag == false) {
                flag = true;
                return Thread.currentThread().getName() + "抽奖成功！";
            }else {
                return Thread.currentThread().getName() + "抽奖失败！";
            }
        }
    }


}
