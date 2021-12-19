package com.yu.case7;

import java.util.concurrent.FutureTask;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className Test
 * @description：
 * @date 2017/12/27 17:46
 */
public class Test {

    public static void main(String[] args) throws Exception{
        int max=10,min=1;
        Thread  tha;
        Thread  thb;
        Thread  thc;
        Thread  thd;
        Thread  the;
        Thread  thf;
        for(int i=1;i<21;i++) {
            PrizeThread thread = new PrizeThread();
            FutureTask<String> ftA = new FutureTask<String>(thread);
            FutureTask<String> ftB = new FutureTask<String>(thread);
            FutureTask<String> ftC = new FutureTask<String>(thread);
            FutureTask<String> ftD = new FutureTask<String>(thread);
            FutureTask<String> ftE = new FutureTask<String>(thread);
            FutureTask<String> ftF = new FutureTask<String>(thread);

            tha= new Thread(ftA, "用户A");
            tha.setPriority((int)(Math.random()*(max-min)+min));
            tha.start();

            thb= new Thread(ftB, "用户B");
            thb.setPriority((int)(Math.random()*(max-min)+min));
            thb.start();

            thc= new Thread(ftC, "用户C");
            thc.setPriority((int)(Math.random()*(max-min)+min));
            thc.start();

            thd= new Thread(ftD, "用户D");
            thd.setPriority((int)(Math.random()*(max-min)+min));
            thd.start();

            the= new Thread(ftE, "用户E");
            the.setPriority((int)(Math.random()*(max-min)+min));
            the.start();

            thf= new Thread(ftF, "用户F");
            thf.setPriority((int)(Math.random()*(max-min)+min));
            thf.start();

            System.out.println("=====第"+i+"轮抽奖开始====");
            System.out.println(ftA.get());
            System.out.println(ftB.get());
            System.out.println(ftC.get());
            System.out.println(ftD.get());
            System.out.println(ftE.get());
            System.out.println(ftF.get());
            System.out.println("=====第"+i+"轮抽奖结束====");
            Thread.sleep(500);
        }
    }

}
