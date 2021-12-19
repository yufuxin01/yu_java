package com.yu.case16;
import org.apache.kafka.clients.consumer.ConsumerRecord;


/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className Worker
 * @description：
 * @date 2017/2/11 11:48
 */
public class Worker implements Runnable{

    private ConsumerRecord<String, String> consumerRecord;

    public Worker(ConsumerRecord record) {
        this.consumerRecord = record;
    }

    @Override
    public void run() {
//        System.out.println(Thread.currentThread().getName() + " consumed: "+ consumerRecord.value());
          consumerRecord.value();
    }

}
