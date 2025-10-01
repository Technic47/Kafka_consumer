package ru.kuznetsov.kafka_consumer.listener;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.kuznetsov.kafka_consumer.dto.MessageDto;
import ru.kuznetsov.kafka_consumer.service.CommentService;

@Component
@RequiredArgsConstructor
public class MessageListener {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final static String GROUP_ID = "tester";
    public final static String MESSAGE_TOPIC_NAME = "message";

    private final CommentService commentService;

    Logger logger = LoggerFactory.getLogger(MessageListener.class);

    @KafkaListener(topics = MESSAGE_TOPIC_NAME, groupId = GROUP_ID)
    public void listenGroupFoo(String message) {
        logger.info("Receiving message: {}", message);
        try {
            commentService.save(objectMapper.readValue(message, MessageDto.class));
        } catch (JsonProcessingException e) {
            logger.error("Error while saving comment: {}", message);
            logger.error(e.getMessage());
        }
    }
}
