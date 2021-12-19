package com.yu.case13;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className CheckService2
 * @description：
 * @date 2017/12/31 11:28
 */
public class CheckService2 {

    public static boolean  check(){
        boolean flag=true;
        try {
            //模拟执行逻辑
            Thread.sleep(1800);
            System.out.println("==CheckService2.check==");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return flag;
    }

}
