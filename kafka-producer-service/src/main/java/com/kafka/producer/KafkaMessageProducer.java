package com.kafka.producer;

import com.kafka.dto.AvroMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageProducer {

  @Value(value = "${spring.kafka.topic}")
  private String topic;

  private final KafkaTemplate<String, AvroMessage> kafkaTemplate;

  public KafkaMessageProducer(final KafkaTemplate<String, AvroMessage> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void send(AvroMessage message) {
    kafkaTemplate.send(topic, message);
  }
}
