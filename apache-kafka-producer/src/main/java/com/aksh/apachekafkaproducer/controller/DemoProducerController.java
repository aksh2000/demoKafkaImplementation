package com.aksh.apachekafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoProducerController {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    // Static Kafka Topic Name
    public static final String TOPIC = "test";


    //Publish a simple string to a Kafka Topic
    @RequestMapping(value = "/publish/{message}", method = RequestMethod.GET)
    public String publishString(@PathVariable("message") String message){

        System.out.println("Message Being Sent : " + message);
        kafkaTemplate.send( TOPIC, message );

        return "Published Successfully";
    }

}
