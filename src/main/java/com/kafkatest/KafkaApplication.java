package com.kafkatest;

import com.kafkatest.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
public class KafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    @KafkaListener(topics = "test", groupId = "test-group-id")
    public void listen(User user){
        log.info("Message reçu : {} ", user);
    }

}
