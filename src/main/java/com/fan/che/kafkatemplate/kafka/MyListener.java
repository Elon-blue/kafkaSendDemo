package com.fan.che.kafkatemplate.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MyListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @KafkaListener(id = "test", topicPartitions = { @TopicPartition(topic = "demo0301", partitions = { "0" }) })
    public void listenPartition0(List<ConsumerRecord<?, ?>> records) {
        System.out.println("Id0 Listener, Thread ID: " + Thread.currentThread().getId());
        System.out.println("Id0 records size " +  records.size());

        for (ConsumerRecord<?, ?> record : records) {
            Optional<?> kafkaMessage = Optional.ofNullable(record.value());
            System.out.println("Received: " + record);
            if (kafkaMessage.isPresent()) {
                Object message = record.value();
                String topic = record.topic();
                System.out.println("p0 Received message={}"+message);

            }
        }
    }







//    /**
//     * 监听topic1主题,单条消费
//     */
//    @KafkaListener(id = "test",topics = "demo0301",containerFactory = "batchFactory")
//public void listen0(ConsumerRecord<String, String> record) {
//    consumer(record);
//    System.out.println("========================");
//    System.out.println("recieve msg:" + record);
//}
//
//    /**
//     * 监听topic2主题,单条消费
//     */
//    @KafkaListener(topics = "${topicName.topic2}")
//    public void listen1(ConsumerRecord<String, String> record) {
//        consumer(record);
//    }
//
//    /**
//     * 监听topic3和topic4,单条消费
//     */
//    @KafkaListener(topics = {"topic3", "topic4"})
//    public void listen2(ConsumerRecord<String, String> record) {
//        consumer(record);
//    }
//
//    /**
//     * 监听topic5,批量消费
//     */
//    @KafkaListener(topics = "${topicName.topic2}", containerFactory = "batchFactory")
//    public void listen2(List<ConsumerRecord<String, String>> records) {
//        batchConsumer(records);
//    }
//
//    /**
//     * 单条消费
//     */
//    public void consumer(ConsumerRecord<String, String> record) {
//        logger.debug("主题:{}, 内容: {}", record.topic(), record.value());
//    }
//
//    /**
//     * 批量消费
//     */
//    public void batchConsumer(List<ConsumerRecord<String, String>> records) {
//        records.forEach(record -> consumer(record));
//    }
}

