package com.yu.case18;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className Test
 * @description：
 * @date 2017/11/25 12:41
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<100;i++) {
            Logger.log("hello test");
            Logger.log("hello test2");
            Logger.log("hello test3");
            Thread.sleep(100);
        }

    }

}
