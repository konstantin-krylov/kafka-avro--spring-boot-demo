package com.kafka.controller;


import com.kafka.dto.AvroMessage;
import com.kafka.producer.KafkaMessageProducer;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

  public ProducerController(final KafkaMessageProducer producer) {
    this.producer = producer;
  }

  private final KafkaMessageProducer producer;

  //  @Scheduled(fixedRate = 50)
  @GetMapping("/test")
  public void get() {
    AvroMessage message = new AvroMessage("Message", UUID.randomUUID().toString(), 12);
    producer.send(message);
  }

}
