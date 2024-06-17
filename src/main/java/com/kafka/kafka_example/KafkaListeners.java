package com.kafka.kafka_example;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    // method to listen

    // Method to listen to messages from the "kafkaExample" topic
    @KafkaListener(topics = "kafkaExample", groupId = "groupId")
    public void listener(String data) {
        System.out.println("Listener received: " + data + " 🎉");
    }

}
