package com.yu.case13;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className CheckService1
 * @description：
 * @date 2017/12/31 11:27
 */
public class CheckService1 {

   public static boolean  check(){
       boolean flag=true;
       try {
           //模拟执行逻辑
           Thread.sleep(2500);
           System.out.println("==CheckService1.check==");
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       return flag;
   }

}
