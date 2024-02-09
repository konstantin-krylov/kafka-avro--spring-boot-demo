package com.kafka.consumer;

import com.kafka.dto.AvroMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaNotificationConsumer {

  @KafkaListener(
      topics = "#{'${spring.kafka.topics}'.split(',')}",
      groupId = "#'${spring.kafka.consumer.group-id}'"
  )
  public void listen(AvroMessage message) {
    log.info("Message received: " + message);
  }

}
