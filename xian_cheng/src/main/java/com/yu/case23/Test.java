package com.yu.case23;

import java.util.Random;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className Test
 * @description：
 * @date 2017/2/1 20:22
 */
public class Test {

    public static void main(String[] args) {
        Master master = new Master(new Worker(), 200);
        Random r = new Random();
        //10000 个任务
        for(int i = 1; i <= 10000; i++){
            Product t = new Product();
            t.setPrdId(i);
            t.setPrdPrice(r.nextInt(1000));
            //添加任务
            master.submit(t);
        }
        //执行任务
        master.execute();
        long start = System.currentTimeMillis();

        while(true){
            if(master.isComplete()){
                long end = System.currentTimeMillis() - start;
                int priceResult = master.getResult();
                System.out.println("最终结果：" + priceResult + ", 执行时间：" + end+" ms");
                break;
            }
        }

    }

}
