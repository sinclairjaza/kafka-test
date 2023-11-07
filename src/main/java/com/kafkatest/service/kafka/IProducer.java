package com.kafkatest.service.kafka;

import com.kafkatest.model.User;

public interface IProducer {
    void send(String topicName, User user);
}
