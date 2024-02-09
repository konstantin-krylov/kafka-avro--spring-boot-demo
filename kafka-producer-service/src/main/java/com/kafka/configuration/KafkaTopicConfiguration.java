package com.kafka.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfiguration {

  @Value(value = "${spring.kafka.topic}")
  private String topic;

  @Value(value = "${spring.kafka.producer.properties.replication.factor}")
  private short replicationFactor;

  @Bean
  public NewTopic newTopic() {
    return new NewTopic(topic, 3, replicationFactor);
  }

}
