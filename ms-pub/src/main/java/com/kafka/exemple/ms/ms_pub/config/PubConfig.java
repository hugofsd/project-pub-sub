package com.kafka.exemple.ms.ms_pub.config;
import com.kafka.exemple.ms.ms_pub.model.JsonMessage;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PubConfig {

    String bootstrapServers = "localhost:29092";

    String defaultTopic = "My.Test.Topic.1";


    @Bean
	public ProducerFactory<String, JsonMessage> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    // retornar kafka template
    @Bean
	public KafkaTemplate<String, JsonMessage> kafkaTemplate(){
		KafkaTemplate<String, JsonMessage> template = new KafkaTemplate<>(producerFactory());
        template.setDefaultTopic(defaultTopic);
        return template;
    }

}
