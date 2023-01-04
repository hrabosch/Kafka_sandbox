package org.hrabosch.kafka.kafkaproducer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class InputProducer {

    @Value("${kafka.producer.input.topic}")
    private String INPUT_TOPIC;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public InputProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String string) {
        this.kafkaTemplate.send(INPUT_TOPIC, string);
    }
}
