package com.kafkatest.service.kafka;

import com.kafkatest.model.User;

public interface IConsumer {
    void listen(String topicName, User user);
}
