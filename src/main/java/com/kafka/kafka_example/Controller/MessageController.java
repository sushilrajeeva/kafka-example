package com.kafka.kafka_example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.kafka_example.Model.MessageRequest;


// Creating this message controller class

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    
    @PostMapping()
    public String publish(@RequestBody MessageRequest request) {
        kafkaTemplate.send("kafkaExample", request.message());
        return "Message Published Successfully!";
    }

}
