package com.kafkatest.service.kafka;

import com.kafkatest.model.User;

public interface IProcess {
    void execute(String info, User user);
}
