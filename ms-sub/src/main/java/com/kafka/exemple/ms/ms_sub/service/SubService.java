package com.kafka.exemple.ms.ms_sub.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.exemple.ms.ms_sub.model.JsonMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SubService {

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "My.Test.Topic.1", groupId = "my-group")
    public void consume (String eventMessage) throws JsonProcessingException {

        JsonNode jsonMessage = objectMapper.readTree(eventMessage);

        JsonMessage message = objectMapper.treeToValue(jsonMessage, JsonMessage.class);

        System.out.println("Message received" + message.toString());
    }
}
