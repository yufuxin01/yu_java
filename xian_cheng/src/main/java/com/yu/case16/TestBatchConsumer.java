package com.yu.case16;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className TestBatchConsumer
 * @description：
 * @date 2017/2/11 11:52
 */
public class TestBatchConsumer {

    public static void main(String[] args) {
        String brokerList = "localhost:9092";
        String groupId = "test";
        String topic = "topic1";
//        int workerNum = 100;

        ConsumerHandler consumers = new ConsumerHandler(brokerList, groupId, topic);
        consumers.execute(Constant.workerNum);
//        try {
//            Thread.sleep(1000000);
//        } catch (InterruptedException ignored) {}
        consumers.shutdown();
    }

}
