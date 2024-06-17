package com.kafka.kafka_example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

	@Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
        return args -> {
			// Running it 10 million time
            for (int i = 0; i < 2; i++) {
                kafkaTemplate.send("kafkaExample", "hello kafka :) " + i);
                // try {
                //     Thread.sleep(1000); // Pause for 1 second
                // } catch (InterruptedException e) {
                //     Thread.currentThread().interrupt(); // Restore the interrupted status
                //     throw new RuntimeException(e);
                // }
            }
        };
    }

}
