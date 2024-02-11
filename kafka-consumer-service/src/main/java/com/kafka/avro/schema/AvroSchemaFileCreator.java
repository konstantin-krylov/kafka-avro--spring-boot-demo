package com.kafka.avro.schema;

import java.io.File;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;

@Slf4j
public class AvroSchemaFileCreator {

  public static void main(String[] args) throws IOException {
    Schema schema = SchemaBuilder.record("AvroMessage")
        .namespace("com.kafka.dto")
        .fields()
        .name("messageContent").type().stringType().noDefault()
        .name("messageId").type().stringType().noDefault()
        .name("age").type().intType().noDefault()
        .endRecord();

    GenericRecord personRecord = new GenericData.Record(schema);
    personRecord.put("messageContent", "Message");
    personRecord.put("messageId", "1");
    personRecord.put("age", 30);

    writeAvroRecordToFile(personRecord, schema, "Message.avsc");
  }

  private static void writeAvroRecordToFile(GenericRecord genericRecord, Schema schema,
      String filename) throws IOException {
    File avroFile = new File(filename);

    DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<>(schema);

    DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<>(datumWriter);
    dataFileWriter.create(schema, avroFile);

    dataFileWriter.append(genericRecord);

    dataFileWriter.close();

    log.info("Avro file created: " + filename);
  }

}
