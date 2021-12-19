package com.yu.case13;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className CheckService3
 * @description：
 * @date 2017/12/31 11:28
 */
public class CheckService3 {

    public static boolean  check(){
        boolean flag=true;
        try {
            //模拟执行逻辑
            Thread.sleep(1500);
            System.out.println("==CheckService3.check==");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return flag;
    }

}
