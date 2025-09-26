package ru.kuznetsov.kafka_consumer.listener;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @KafkaListener(topics = "baeldung", groupId = "tester")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group tester: " + message);
    }
}
