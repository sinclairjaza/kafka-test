package com.kafkatest.kafka;

import com.kafkatest.model.User;

public interface IProcess {
    void execute(String info, User user);
}
