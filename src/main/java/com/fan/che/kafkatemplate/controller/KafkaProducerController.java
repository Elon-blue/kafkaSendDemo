package com.fan.che.kafkatemplate.controller;

import com.fan.che.kafkatemplate.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafkaProducer")
public class KafkaProducerController {

    @Autowired
   private KafkaProducer kafkaProducer;

    @GetMapping("/kafkaProducer")
    public void sendMsg() throws InterruptedException {
        System.out.println("1111111111111111111111111111");
        for (int i = 0; i <=10; i++) {
            String topic = "demo0301";
            String message = "this is another message"+i;
            kafkaProducer.send(topic,message);
//            Thread.sleep(5000);
            System.out.println("send message "+i);
        }
        System.out.println("send message over");

    }




}
