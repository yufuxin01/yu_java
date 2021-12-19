package com.yu.case15;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className SingleProducer
 * @description：
 * @date 2017/2/10 21:32
 */
public class SingleProducer {
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


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long t1 = System.currentTimeMillis();
        User user;
        for(int i=1;i<=1000000;i++){
         user=new User();
            user.setId(i);
            user.setName("huanglaoxie-"+i);
            String message=(String) JSON.toJSONString(user);
            ProducerRecord<String,String> record = new ProducerRecord<String,String>(TOPIC,message);
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if(null==exception){
                        System.out.println("perfect!");
                    }
                    if(null!=metadata){
                        System.out.println("offset:"+metadata.offset()+";partition:"+metadata.partition());
                    }
                }
            }).get();
            inc.incrementAndGet();
     }
        System.out.println("生产方每次发送一条消息 , "+String.format("共发送%s条消息，耗时：%s ms",inc.get(),  (System.currentTimeMillis()- t1)));
    }

}
