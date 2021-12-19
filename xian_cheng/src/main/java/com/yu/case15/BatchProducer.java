package com.yu.case15;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className BatchProducer
 * @description：
 * @date 2017/2/9 18:56
 */
public class BatchProducer {

    private static final String TOPIC = "topic1";
    private static final String BATCH_ID = "batchId";
    private static final String USERS = "users";
    private static final String BROKER_LIST = "localhost:9092";
    private static KafkaProducer<String, String> producer = null;
    public static AtomicInteger inc = new AtomicInteger();

    static {
        Properties configs = initConfig();
        producer = new KafkaProducer<String, String>(configs);
    }

    private static Properties initConfig() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_LIST);
        properties.put(ProducerConfig.ACKS_CONFIG, "all");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return properties;
    }

    public static void main(String[] args) throws InterruptedException {
        int batchSize = 5000;
        int batch = 200;
        long t1 = System.currentTimeMillis();
        createMessage(batchSize, batch);
        System.out.println("生产方批量发送消息 , "+String.format("共发送%s条消息，耗时：%s ms",inc.get(),  (System.currentTimeMillis()- t1)));

    }

    public static int createMessage(int batchSize, int batch) throws InterruptedException {
        Thread th;
        for (int i = 1; i <=batch; i++) {
            List theList = new ArrayList<>();
            Map msgMap = new HashMap();
            msgMap.put(BATCH_ID, DistrIdGenerator2.createDistrId());
            System.out.println("batch  is   :  "+i);
            th = new Thread() {
                public void run() {
                    User user;
                    int id;
                    for (int j = 1; j <= batchSize; j++) {
                        user = new User();
                        id = inc.incrementAndGet();
                        user.setId(id);
                        user.setName("huanglaoxie-" + id);
                        theList.add(user);
                    }
                    msgMap.put(USERS, theList);
                    String usersMessage = (String) JSON.toJSONString(msgMap);
                    sendMessage(usersMessage);
                }

                ;
            };
            th.start();
            th.join();

        }
        return inc.get();
    }

    private static void sendMessage(String usersMessage) {
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(TOPIC, usersMessage);
        try {
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if (null == exception) {
                        System.out.println("send message success!");
                    }
//                    if (null != metadata) {
//                        System.out.println("offset:" + metadata.offset() + ";partition:" + metadata.partition());
//                    }
                }
            }).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
