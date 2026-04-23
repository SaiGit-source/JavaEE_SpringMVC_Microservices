package com.usecase.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class KafkaUseCaseConsumer {
    public static void main(String[] args) {

        //Setup Properties for consumer
        Properties kafkaProps = new Properties();

        //List of Kafka brokers to connect to
        kafkaProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "localhost:9092");

        //Deserializer class to convert Keys from Byte Array to String
        kafkaProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");

        //Deserializer class to convert Messages from Byte Array to String
        kafkaProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");

        //Consumer Group ID for this consumer
        kafkaProps.put(ConsumerConfig.GROUP_ID_CONFIG,
                "kafka-java-consumer");

        //Set to consume from the earliest message, on start when no offset is
        //available in Kafka
        kafkaProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,
                "earliest");

        //Create a Consumer
        KafkaConsumer<String, String> simpleConsumer =
                new KafkaConsumer<String,String>(kafkaProps);

        //Subscribe to the kafka.learning.orders topic
        simpleConsumer.subscribe(Arrays.asList("kafka.usecase.students"));

        //Continuously poll for new messages
        while(true) {

            //Poll with timeout of 100 milli seconds
            ConsumerRecords<String, String> messages =
                    simpleConsumer.poll(Duration.ofMillis(100));

            //Print batch of records consumed
            for (ConsumerRecord<String, String> message : messages)
                System.out.println("Message fetched : " + message);
        }

    }
}


/* Output
Message fetched : ConsumerRecord(topic = kafka.usecase.students, partition = 1, leaderEpoch = 0, offset = 0, CreateTime = 1776975281709, serialized key size = 3, serialized value size = 21, headers = RecordHeaders(headers = [], isReadOnly = false), key = 906, value = This is student : 906)
Message fetched : ConsumerRecord(topic = kafka.usecase.students, partition = 1, leaderEpoch = 0, offset = 1, CreateTime = 1776975283736, serialized key size = 3, serialized value size = 21, headers = RecordHeaders(headers = [], isReadOnly = false), key = 907, value = This is student : 907)
Message fetched : ConsumerRecord(topic = kafka.usecase.students, partition = 1, leaderEpoch = 0, offset = 2, CreateTime = 1776975285737, serialized key size = 3, serialized value size = 21, headers = RecordHeaders(headers = [], isReadOnly = false), key = 908, value = This is student : 908)
Message fetched : ConsumerRecord(topic = kafka.usecase.students, partition = 1, leaderEpoch = 0, offset = 3, CreateTime = 1776975291740, serialized key size = 3, serialized value size = 21, headers = RecordHeaders(headers = [], isReadOnly = false), key = 911, value = This is student : 911)
Message fetched : ConsumerRecord(topic = kafka.usecase.students, partition = 1, leaderEpoch = 0, offset = 4, CreateTime = 1776975433388, serialized key size = 3, serialized value size = 21, headers = RecordHeaders(headers = [], isReadOnly = false), key = 166, value = This is student : 166)
Message fetched : ConsumerRecord(topic = kafka.usecase.students, partition = 1, leaderEpoch = 0, offset = 5, CreateTime = 1776975437420, serialized key size = 3, serialized value size = 21, headers = RecordHeaders(headers = [], isReadOnly = false), key = 168, value = This is student : 168)
Message fetched : ConsumerRecord(topic = kafka.usecase.students, partition = 1, leaderEpoch = 0, offset = 6, CreateTime = 1776975441425, serialized key size = 3, serialized value size = 21, headers = RecordHeaders(headers = [], isReadOnly = false), key = 170, value = This is student : 170)
Message fetched : ConsumerRecord(topic = kafka.usecase.students, partition = 1, leaderEpoch = 0, offset = 7, CreateTime = 1776975445427, serialized key size = 3, serialized value size = 21, headers = RecordHeaders(headers = [], isReadOnly = false), key = 172, value = This is student : 172)
Message fetched : ConsumerRecord(topic = kafka.usecase.students, partition = 1, leaderEpoch = 0, offset = 8, CreateTime = 1776975447428, serialized key size = 3, serialized value size = 21, headers = RecordHeaders(headers = [], isReadOnly = false), key = 173, value = This is student : 173)
Message fetched : ConsumerRecord(topic = kafka.usecase.students, partition = 1, leaderEpoch = 0, offset = 9, CreateTime = 1776975449429, serialized key size = 3, serialized value size = 21, headers = RecordHeaders(headers = [], isReadOnly = false), key = 174, value = This is student : 174)
Message fetched : ConsumerRecord(topic = kafka.usecase.students, partition = 0, leaderEpoch = 0, offset = 0, CreateTime = 1776975287737, serialized key size = 3, serialized value size = 21, headers = RecordHeaders(headers = [], isReadOnly = false), key = 909, value = This is student : 909)
Message fetched : ConsumerRecord(topic = kafka.usecase.students, partition = 0, leaderEpoch = 0, offset = 1, CreateTime = 1776975289739, serialized key size = 3, serialized value size = 21, headers = RecordHeaders(headers = [], isReadOnly = false), key = 910, value = This is student : 910)
Message fetched : ConsumerRecord(topic = kafka.usecase.students, partition = 0, leaderEpoch = 0, offset = 2, CreateTime = 1776975293741, serialized key size = 3, serialized value size = 21, headers = RecordHeaders(headers = [], isReadOnly = false), key = 912, value = This is student : 912)
Message fetched : ConsumerRecord(topic = kafka.usecase.students, partition = 0, leaderEpoch = 0, offset = 3, CreateTime = 1776975435419, serialized key size = 3, serialized value size = 21, headers = RecordHeaders(headers = [], isReadOnly = false), key = 167, value = This is student : 167)
Message fetched : ConsumerRecord(topic = kafka.usecase.students, partition = 0, leaderEpoch = 0, offset = 4, CreateTime = 1776975439423, serialized key size = 3, serialized value size = 21, headers = RecordHeaders(headers = [], isReadOnly = false), key = 169, value = This is student : 169)
Message fetched : ConsumerRecord(topic = kafka.usecase.students, partition = 0, leaderEpoch = 0, offset = 5, CreateTime = 1776975443426, serialized key size = 3, serialized value size = 21, headers = RecordHeaders(headers = [], isReadOnly = false), key = 171, value = This is student : 171)
Message fetched : ConsumerRecord(topic = kafka.usecase.students, partition = 0, leaderEpoch = 0, offset = 6, CreateTime = 1776975451430, serialized key size = 3, serialized value size = 21, headers = RecordHeaders(headers = [], isReadOnly = false), key = 175, value = This is student : 175)
*/

/* Triggered Producer manually StudentID and Scores
Message fetched : ConsumerRecord(topic = kafka.usecase.students, partition = 1, leaderEpoch = 0, offset = 10, CreateTime = 1776976621743, serialized key size = 3, serialized value size = 3, headers = RecordHeaders(headers = [], isReadOnly = false), key = 102, value =  90)
Message fetched : ConsumerRecord(topic = kafka.usecase.students, partition = 0, leaderEpoch = 0, offset = 7, CreateTime = 1776976618987, serialized key size = 3, serialized value size = 3, headers = RecordHeaders(headers = [], isReadOnly = false), key = 101, value =  76)
Message fetched : ConsumerRecord(topic = kafka.usecase.students, partition = 0, leaderEpoch = 0, offset = 8, CreateTime = 1776976624973, serialized key size = 3, serialized value size = 3, headers = RecordHeaders(headers = [], isReadOnly = false), key = 103, value =  40)
*/