package com.yu.case22;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className Test
 * @description：
 * @date 2017/12/30 14:23
 */
public class Test {

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++){
            new Thread(new Request()).start();
        }
    }


}
