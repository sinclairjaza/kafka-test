package com.kafkatest.kafka;

import com.kafkatest.model.User;

public interface IReceiver {
    void listen(String topicName, User user);
}
