## kafka-avro-spring-boot-demo

Project for showing ability kafka to work with avro

### Running locally

Start a local kafka message broker with docker, producer service and consumer service

In IntelliJ start `com.kafka.KafkaProducerServiceApplication` for producer starting
and `com.kafka.KafkaConsumerServiceApplication` for consumer starting.

### Local kafka brokers

Navigate to `docker/docker-compose.yml` and run `docker-compose -f docker-compose.yml up -d`, to
setup the local zookeeper, three kafka brokers and kafka-ui.

### Kafka-ui

Navigate to `http://localhost:8080/` to visit kafka-ui.

### Avro schema generation

Use `com.kafka.avro.schema.AvroSchemaFileCreator` to generate .avcs schema file. To generate java
object from avro file use `maven clean install`