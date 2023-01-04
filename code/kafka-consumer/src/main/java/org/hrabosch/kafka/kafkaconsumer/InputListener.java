package org.hrabosch.kafka.kafkaconsumer;

import java.util.LinkedList;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class InputListener {

    private LinkedList<String> receivedMessages = new LinkedList<>();

    @KafkaListener(topics = "${kafka.consumer.input.topic}")
    public void listen(String message) {
        receivedMessages.add(message);
    }

    public String getLastMessage() {
        return receivedMessages.isEmpty() ? "No message avaialble" : receivedMessages.getLast();
    }
}
