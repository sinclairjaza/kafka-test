package com.kafkatest.rest;

import com.kafkatest.model.User;
import com.kafkatest.service.KafkaProducerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafkatest")
@AllArgsConstructor
public class KafkaController {

    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/producer/{topic}")
    public String sendMessage(@RequestBody User user, @PathVariable String topic){

        kafkaProducerService.send(topic, user);

        return "Message envoyé au topic kafka " + topic ;
    }
}
