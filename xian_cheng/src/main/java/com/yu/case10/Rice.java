package com.yu.case10;

import java.util.concurrent.Callable;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className Rice
 * @description：
 * @date 2017/1/15 18:07
 */
public class Rice implements Callable {

    @Override
    public Rice call() throws Exception {

        {
            System.out.println("开始煮饭");
            Thread.sleep(5000);  // 模拟煮饭时间
            System.out.println("煮饭完成");
            return new Rice();
        }
    }
}
