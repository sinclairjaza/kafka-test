package com.kafkatest.service;

import com.kafkatest.service.kafka.IProducer;
import com.kafkatest.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class KafkaProducerService implements IProducer {

    private final KafkaTemplate<String, User> kafkaTemplate;

    /**
     * Permet d'envoyer un message dans un topic
     */
    /*public void send(String topicName, User user){
        log.debug("Envoi du message au topic {} ", topicName);
        new NewTopic(topicName, 1, (short) 1);
        kafkaTemplate.send(topicName, user);
    }
    */
    public void send(String topicName, User user){
        final ProducerRecord<String, User> producerRecord = new ProducerRecord<>(topicName, String.valueOf(user.getAge()), user);

        producerRecord.headers().add("event_type", "ADD USER".getBytes());
        producerRecord.headers().add("user_age", String.valueOf(user.getAge()).getBytes());

        kafkaTemplate.send(producerRecord)
                .whenComplete((result, ex) -> {
                    if(ex == null){
                        log.info("Message envoyé avec succèss");
                        log.debug("INFO MESSAGE RESULT {} ", result);
                    }else {
                        log.error("Impossible d'envoyer le message", ex);
                    }
                });
    }
}
