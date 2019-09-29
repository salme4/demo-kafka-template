package com.myhome.demokafkatemplate.controller;

import com.myhome.demokafkatemplate.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class KafkaProducerController {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerController.class);

    private KafkaTemplate<String, User> kafkaTemplate;
    private static final String TOPIC = "dave_json2";

    public KafkaProducerController(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/publish/{message}")
    public String publishingMessage(@PathVariable("message")String message) throws Exception {
        logger.info("publish message : {}", message);
        kafkaTemplate.send(TOPIC, new User(message));
        return "success send messages + " + message;
    }


}
