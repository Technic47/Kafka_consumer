package ru.kuznetsov.kafka_consumer.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.kuznetsov.kafka_consumer.dto.MessageDto;
import ru.kuznetsov.kafka_consumer.listener.MessageListener;
import ru.kuznetsov.kafka_consumer.model.CommentEntity;
import ru.kuznetsov.kafka_consumer.repository.CommentRepository;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    Logger logger = LoggerFactory.getLogger(MessageListener.class);

    public void save(CommentEntity comment) {
        logger.info("Save comment");

        commentRepository.save(comment);

        logger.info("Comment saved");
    }

    public void save(MessageDto messageDto) {
        save(new CommentEntity(
                messageDto.getMessage(),
                messageDto.getAuthor(),
                new Date()
        ));
    }
}
