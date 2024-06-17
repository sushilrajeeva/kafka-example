package com.kafka.kafka_example.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class kafkaProducerConfig {

    // Injecting the Kafka bootstrap servers from the application properties
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapService;

    // Method to configure the producer properties
    public Map<String, Object> producerConfig(){
        // Creating a map to hold the producer configurations
        Map<String, Object> props = new HashMap<>();
        // Setting the bootstrap servers for the Kafka producer
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapService);
        // Setting the key serializer class to StringSerializer
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        // Setting the value serializer class to StringSerializer
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        // Returning the producer configuration map
        return props;

    }

    // Defining a bean to create a ProducerFactory
    // The second input here is String but if we want to send our custom object like customer, notification or any object type we can replace it with that
    @Bean
    public ProducerFactory<String, String> producerFactory(){
        // Creating a DefaultKafkaProducerFactory with the producer configuration
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    // PRODUCER CONFIG ALLOWS US TO CREATE KAFKA PRODUCERS, NOW WE NEED TO SEND MESSAGES WITH KAFKA TEMPLATE 

    // second string can be replaced with our custom object type
   
    // Defining a bean to create a KafkaTemplate

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> producerFactory){
        // Creating a KafkaTemplate using the provided ProducerFactory
        return new KafkaTemplate<>(producerFactory);
    }



}
