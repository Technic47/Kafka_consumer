package ru.kuznetsov.kafka_consumer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDto {
    private String author;
    private String message;
}
