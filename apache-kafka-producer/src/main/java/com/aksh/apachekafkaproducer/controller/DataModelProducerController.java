package com.aksh.apachekafkaproducer.controller;

import com.aksh.apachekafkaproducer.dataModels.RandomDataModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/publishDataModel")
public class DataModelProducerController {

    @Autowired
    KafkaTemplate<String, RandomDataModel> kafkaTemplate;

    // Static Kafka Topic Name
    public static final String TOPIC = "test";


    //Publish a simple string to a Kafka Topic
    @PostMapping(value = "/p")
    public String publishString(@RequestBody RandomDataModel message){

        System.out.println("Message Being Sent : " + message);
        kafkaTemplate.send( TOPIC, message );

        return "Message Published Succesfully";

    }
    
}
