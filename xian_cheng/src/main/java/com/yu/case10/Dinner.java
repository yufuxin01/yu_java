package com.yu.case10;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className Dinner
 * @description：
 * @date 2017/1/15 18:42
 */
public class Dinner {

    public static void haveDinner() throws InterruptedException, ExecutionException {
        Rice rice = new Rice();
        FutureTask<Rice> riceTask = new FutureTask<Rice>(rice);
        new Thread(riceTask).start();

        Vegetable vegetable=new Vegetable();
        FutureTask<Vegetable> vegetableTask = new FutureTask<Vegetable>(vegetable);
        Thread veg= new Thread(vegetableTask);
        veg.start();
        veg.join();

        Cook cook=new Cook();
        FutureTask<Cook> cookTask = new FutureTask<Cook>(cook);
        new Thread(cookTask).start();

        if(!cookTask.isDone()){ // 任务是否已经完成,如果完成,返回true
            System.out.println("菜没炒好，就继续等吧");
        }
        if(!riceTask.isDone()){
            System.out.println("饭没煮好，就继续等吧");
        }
		//获取执行结果,这个方法会产生阻塞,会一直等到任务执行完毕才返回结果
        Rice riceResult= riceTask.get();
        Cook cookResult=cookTask.get();
        if(null!=riceResult&&null!=cookResult) {
            System.out.println("菜炒好了，饭也煮好了，大家一起吃饭吧");

        }
    }

}
