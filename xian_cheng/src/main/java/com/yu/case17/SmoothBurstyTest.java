package com.yu.case17;

import com.google.common.util.concurrent.RateLimiter;

/** 
 * Filename:     SmoothBurstyTest.java
 * @Copyright:   Copyright (c)2017 
 * @Company:     jd 
 * @author:      huanglaoxie
 * @function:    平滑突发限流(SmoothBursty)
 * @version:     1.0 
 * @Create at:   2017年4月25日 上午7:16:00 
 */
public class SmoothBurstyTest {
    public static void main(String[] args) {
        //每秒允许5个请求，表示桶容量为5且每秒新增5个令牌，即每隔0.2秒新增一个令牌
        RateLimiter limiter = RateLimiter.create(5);
        //如果当前桶中有足够令牌则成功（返回值为0）返回获取token的耗时，以秒为单位
        //将突发请求速率平均为了固定请求速率，固定频率=0.2s/个
        //允许突发流量
        System.out.println(limiter.acquire(6));
        //接下来的limiter.acquire(1)将等待差不多2秒桶中才能有令牌，且接下来的请求也整形为固定速率了
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
    }
}
