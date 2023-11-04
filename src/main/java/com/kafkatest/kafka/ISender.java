package com.kafkatest.kafka;

import com.kafkatest.model.User;

public interface ISender {
    void send(String topicName, User user);
}
