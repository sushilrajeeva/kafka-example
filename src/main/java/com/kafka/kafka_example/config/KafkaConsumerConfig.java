package com.kafka.kafka_example.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

@Configuration
public class KafkaConsumerConfig {

    @Value("localhost:9092")
    private String bootstrapServers;

    // Method to configure the consumer properties
    public Map<String, Object> consumerConfig(){
        // Creating a map to hold the consumer configurations
        Map<String, Object> props = new HashMap<>();
        // Setting the bootstrap servers for the Kafka producer
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        // Setting the key deserializer class to StringSerializer
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        // Setting the value deserializer class to StringSerializer
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        // Returning the consumer configuration map
        return props;

    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory(){
        // Creating a DefaultKafkaProducerFactory with the producer configuration
        return new DefaultKafkaConsumerFactory<>(consumerConfig());
    }

    // Specifiying the listner container factory

    // This listner recieves all the messages from all topics or all partitions from a single thread
    public KafkaListenerContainerFactory<
    ConcurrentMessageListenerContainer<String, String>> factory(
        ConsumerFactory<String, String> consumerFactory
    ){
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }

}
