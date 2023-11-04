package com.kafkatest.kafka;

import com.kafkatest.model.User;
import org.springframework.stereotype.Service;

/**
 * Traitement des messages reçu
 */
@Service
public class ProcessExample implements IProcess {
    @Override
    public void execute(String info, User user) {
        System.out.println("Message reçu : INFO = " + info + ", USER = " + user);
    }
}
