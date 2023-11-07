package com.kafkatest.service.kafka;

import com.kafkatest.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Service qui recoit les messages Kafka
 */
@Service
@AllArgsConstructor
@Slf4j
public class KafkaConsumer implements IConsumer {

    private final IProcess process;

    /**
     * Exécution d'un traitement
     */
    @Override
    public void listen(String topicName, User user) {
     process.execute(topicName + " _info ", user);
    }

    /**
     * Ecoute sur le topic "Topic1" s'il existe un message
     * */
    @KafkaListener(topics = "Topic1", groupId = "kafka-test-group-id", containerFactory = "kafkaListenerContainerFactory")
    public void listenTopic1(User user){
        //listen("Topic1", user);
        log.info("MESSAGE LISTEN SUCCESSFULY ...");

    }

    /**
     * Ecoute sur le topic "Topic2" s'il existe un message
     * */
    @KafkaListener(topics = "Topic3", groupId = "kafka-test-group-id", containerFactory = "kafkaListenerContainerFactory")
    public void listenTopic3(User user){
        listen("Topic3", user);
    }

    @KafkaListener(topics = "Topic2", groupId = "kafka-test-group-id", containerFactory = "kafkaListenerContainerFactory")
    public void listenTopic2(ConsumerRecord<String, User> consumerRecord){

        log.info("MESSAGE LISTEN SUCCESSFULY ... {}", consumerRecord);
    }
}
