package com.kafkatest.service;

import com.kafkatest.kafka.ISender;
import com.kafkatest.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class KafkaProducerService implements ISender {

    private final KafkaTemplate<String, User> kafkaTemplate;

    /**
     * Permet d'envoyer un message dans un topic
     */
    public void send(String topicName, User user){
        log.debug("Envoi du message au topic {} ", topicName);
        new NewTopic(topicName, 1, (short) 1);
        kafkaTemplate.send(topicName, user);
    }
}
