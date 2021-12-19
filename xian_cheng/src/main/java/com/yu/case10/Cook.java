package com.yu.case10;

import java.util.concurrent.Callable;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className Cook
 * @description：
 * @date 2017/1/15 18:20
 */
public class Cook implements Callable {
    @Override
    public Cook call() throws Exception {
        System.out.println("开始炒菜");
       // 模拟炒菜时间
//        Thread.sleep(2000);
        Thread.sleep(8000);
        Cook cook = new Cook();
        System.out.println("炒菜完毕");
        return cook;
    }
}
