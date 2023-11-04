package com.kafkatest.kafka;

import com.kafkatest.model.User;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Service qui recoit les messages Kafka
 */
@Service
@AllArgsConstructor
public class KafkaReceiver implements IReceiver{

    private final IProcess process;

    /**
     * Exécution d'un traitement
     */
    @Override
    public void listen(String topicName, User user) {
     process.execute(topicName + "_info", user);
    }

    /**
     * Ecoute sur le topic "Topic1" s'il existe un message
     * */
    @KafkaListener(topics = "Topic1", containerFactory = "kafkaListenerContainerFactory")
    public void listenTopic1(User user){
        listen("Topic1", user);
    }

    /**
     * Ecoute sur le topic "Topic2" s'il existe un message
     * */
    @KafkaListener(topics = "Topic2", containerFactory = "kafkaListenerContainerFactory")
    public void listenTopic2(User user){
        listen("Topic2", user);
    }
}
