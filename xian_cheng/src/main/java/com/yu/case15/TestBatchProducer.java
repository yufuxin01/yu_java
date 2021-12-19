package com.yu.case15;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className TestBatchProducer
 * @description：
 * @date 2017/2/11 12:50
 */
public class TestBatchProducer {

    public static void main(String[] args) throws InterruptedException {
        long t1 = System.currentTimeMillis();
        int count= BatchProducer.createMessage(Constant.batchSize, Constant.batch);
        System.out.println("生产方批量发送消息 , "+String.format("共发送%s条消息，耗时：%s ms",count,  (System.currentTimeMillis()- t1)));
    }

}
