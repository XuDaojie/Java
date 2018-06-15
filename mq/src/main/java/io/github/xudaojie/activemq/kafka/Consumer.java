package io.github.xudaojie.activemq.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class Consumer {

    public static void receiveMsg() {
        Properties props = new Properties();
        props.put("bootstrap.servers", Constants.BOOTSTRAP_SERVERS);
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("test-topic-xdj"));
//        consumer.subscribe(Arrays.asList("app"));
        int i = 0;
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
//                if (record.value().contains("\t28428\t")) {
                    System.out.printf("idx: " + i++ + " offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
//                }
            }
        }
    }

    public static void main(String[] args) {
        Consumer.receiveMsg();
    }

}
