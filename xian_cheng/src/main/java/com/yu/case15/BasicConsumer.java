package com.yu.case15;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className BasicConsumer
 * @description：
 * @date 2017/2/8 21:18
 */
public class BasicConsumer {

    private static final String TOPIC="topic1";
    private static final String BROKER_LIST="localhost:9092";
    private static KafkaConsumer<String,String> kafkaConsumer = null;

    static {
        Properties properties = initConfig();
        kafkaConsumer = new KafkaConsumer<String, String>(properties);
        kafkaConsumer.subscribe(Arrays.asList(TOPIC));
    }

    private static Properties initConfig(){
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,BROKER_LIST);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"test");
        properties.put(ConsumerConfig.CLIENT_ID_CONFIG,"test");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
        return properties;
    }

//    ConsumerRecords<String,String> records = kafkaConsumer.poll(100);

    public static void main(String[] args){
        consumeMessage();
    }

    public static void  consumeMessage(){
        try{
            while(true){
                ConsumerRecords<String,String> records = kafkaConsumer.poll(Duration.ofMillis(100));
                for(ConsumerRecord record:records){
                    try{
                        System.out.println(record.value());
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            kafkaConsumer.close();
        }
    }

}
