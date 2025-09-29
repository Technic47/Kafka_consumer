package ru.kuznetsov.kafka_consumer.listener;


import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.kuznetsov.kafka_consumer.model.CommentEntity;
import ru.kuznetsov.kafka_consumer.service.CommentService;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class MessageListener {

    private final static String GROUP_ID = "tester";

    private final CommentService commentService;

    @KafkaListener(topics = "baeldung", groupId = GROUP_ID)
    public void listenGroupFoo(String message) {
        commentService.save(new CommentEntity(message, GROUP_ID, new Date()));
    }
}
