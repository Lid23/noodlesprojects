package com.noodles.kafka.api;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ProducerApi {

    public static String kafkaUrl = "10.168.12.90:9092";

    public static void main(String args[]){
        /**一个简单的例子，发送一个有序的键值对*/
        Properties props = new Properties();

        props.put("bootstrap.servers", kafkaUrl);
        /**判别请求是否为完整的条件，all 将会阻塞消息，这种设置性能最低，单最可靠*/
        props.put("acks", "all");
        /**如果请求失败，重试次数*/
        props.put("retries", 0);

        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++) {
            producer.send(new ProducerRecord<String, String>("my-topic2", Integer.toString(i), Integer.toString(i)));
        }
        producer.close();

        System.out.println("done");
    }
}
