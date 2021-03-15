package com.fan.che.kafkatemplate.controller;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/kafkaProducer")
public class KafkaProducerController {

    private final static Logger logger = LoggerFactory.getLogger(KafkaProducerController.class);




    @RequestMapping(value = "/{topic}/send",method = RequestMethod.GET)
    public void sendMeessageTotopic2(@PathVariable String topic, @RequestParam(value = "partition",defaultValue = "0") int partition) {
//        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>();
        logger.info("start send message to {}",topic);
        for (int i = 0; i <=10; i++) {

            long startTime = System.currentTimeMillis();
            System.out.println("===startTime "+startTime);
            String message = Long.toString(startTime);
            System.out.println("start send message:"+message);
//            kafkaProducer.send(topic,partition,"demo0315",message);

        }

        System.out.println("send message over");
    }








}
