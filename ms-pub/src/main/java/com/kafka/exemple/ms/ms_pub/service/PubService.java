package com.kafka.exemple.ms.ms_pub.service;

import com.kafka.exemple.ms.ms_pub.model.JsonMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PubService {

	@Autowired
	private KafkaTemplate<String, JsonMessage> producerTemplate;

	public void send(JsonMessage message) {
		System.out.println("Sending: " + message);
		producerTemplate.sendDefault(message);
	}
}
