package ru.kuznetsov.kafka_consumer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuznetsov.kafka_consumer.model.CommentEntity;
import ru.kuznetsov.kafka_consumer.repository.CommentRepository;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public void save(CommentEntity comment) {
        commentRepository.save(comment);
    }
}
