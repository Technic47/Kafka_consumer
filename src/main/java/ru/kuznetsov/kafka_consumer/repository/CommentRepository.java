package ru.kuznetsov.kafka_consumer.repository;

import org.springframework.stereotype.Repository;
import ru.kuznetsov.kafka_consumer.model.CommentEntity;

@Repository
public interface CommentRepository extends AbstractRepository<CommentEntity>{
}
