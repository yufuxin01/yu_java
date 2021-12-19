package com.yu.case10;

import java.util.concurrent.Callable;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className Vegetable
 * @description：
 * @date 2017/1/15 18:30
 */
public class Vegetable implements Callable {

    public Vegetable call() throws Exception {
        System.out.println("开始买菜、洗菜");
        Thread.sleep(1000);  // 模拟买菜，洗菜时间
        System.out.println("买菜、洗菜已完成");
        return new Vegetable();
    }
}
