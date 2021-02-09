package com.aksh.apachekafkaproducer.configuration;

import java.util.HashMap;
import java.util.Map;

import com.aksh.apachekafkaproducer.dataModels.RandomDataModel;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class kafkaConfiguration {

    // configuration required to send datamodels as messages instread of simple strings

    @Bean
    public ProducerFactory<String, RandomDataModel> producerFactory() {
        Map<String, Object> config = new HashMap<>();

        // default port kafka : 9092
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.177.68.58:9092");

        // String Serializer because Key is String
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        // Json Serializer because Value (Random Data Model) would be in json format
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(config);

    }


    @Bean
    public KafkaTemplate kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}
