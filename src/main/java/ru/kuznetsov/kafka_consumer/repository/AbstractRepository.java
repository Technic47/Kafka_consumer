package ru.kuznetsov.kafka_consumer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.kuznetsov.kafka_consumer.model.AbstractEntity;

@NoRepositoryBean
public interface AbstractRepository<E extends AbstractEntity> extends CrudRepository<E, Long> {
}
