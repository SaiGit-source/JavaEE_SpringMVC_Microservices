package com.example.consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Consumer {

    
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
        simpleConsumer.subscribe(Arrays.asList("kafka.learning.orders"));

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
Message fetched : ConsumerRecord(topic = kafka.learning.orders, partition = 1, leaderEpoch = 0, offset = 0, CreateTime = 1776963279776, serialized key size = 4, serialized value size = 18, headers = RecordHeaders(headers = [], isReadOnly = false), key = 1003, value =  "Monitor, 100.00")
Message fetched : ConsumerRecord(topic = kafka.learning.orders, partition = 1, leaderEpoch = 0, offset = 1, CreateTime = 1776963310533, serialized key size = 4, serialized value size = 18, headers = RecordHeaders(headers = [], isReadOnly = false), key = 1004, value =  "Keyboard, 25.00")
Message fetched : ConsumerRecord(topic = kafka.learning.orders, partition = 1, leaderEpoch = 0, offset = 2, CreateTime = 1776969400577, serialized key size = 3, serialized value size = 19, headers = RecordHeaders(headers = [], isReadOnly = false), key = 992, value = This is order : 992)
Message fetched : ConsumerRecord(topic = kafka.learning.orders, partition = 1, leaderEpoch = 0, offset = 3, CreateTime = 1776969402617, serialized key size = 3, serialized value size = 19, headers = RecordHeaders(headers = [], isReadOnly = false), key = 993, value = This is order : 993)
Message fetched : ConsumerRecord(topic = kafka.learning.orders, partition = 1, leaderEpoch = 0, offset = 4, CreateTime = 1776969416626, serialized key size = 4, serialized value size = 20, headers = RecordHeaders(headers = [], isReadOnly = false), key = 1000, value = This is order : 1000)
Message fetched : ConsumerRecord(topic = kafka.learning.orders, partition = 2, leaderEpoch = 0, offset = 0, CreateTime = 1776963419307, serialized key size = 4, serialized value size = 18, headers = RecordHeaders(headers = [], isReadOnly = false), key = 1005, value =  "Monitor, 123.00")
Message fetched : ConsumerRecord(topic = kafka.learning.orders, partition = 2, leaderEpoch = 0, offset = 1, CreateTime = 1776963948918, serialized key size = 4, serialized value size = 14, headers = RecordHeaders(headers = [], isReadOnly = false), key = 1006, value =  "HDD, 345.34")
Message fetched : ConsumerRecord(topic = kafka.learning.orders, partition = 2, leaderEpoch = 0, offset = 2, CreateTime = 1776969404618, serialized key size = 3, serialized value size = 19, headers = RecordHeaders(headers = [], isReadOnly = false), key = 994, value = This is order : 994)
Message fetched : ConsumerRecord(topic = kafka.learning.orders, partition = 2, leaderEpoch = 0, offset = 3, CreateTime = 1776969406619, serialized key size = 3, serialized value size = 19, headers = RecordHeaders(headers = [], isReadOnly = false), key = 995, value = This is order : 995)
Message fetched : ConsumerRecord(topic = kafka.learning.orders, partition = 2, leaderEpoch = 0, offset = 4, CreateTime = 1776969408622, serialized key size = 3, serialized value size = 19, headers = RecordHeaders(headers = [], isReadOnly = false), key = 996, value = This is order : 996)
Message fetched : ConsumerRecord(topic = kafka.learning.orders, partition = 2, leaderEpoch = 0, offset = 5, CreateTime = 1776969410623, serialized key size = 3, serialized value size = 19, headers = RecordHeaders(headers = [], isReadOnly = false), key = 997, value = This is order : 997)
Message fetched : ConsumerRecord(topic = kafka.learning.orders, partition = 0, leaderEpoch = 0, offset = 0, CreateTime = 1776958319037, serialized key size = 4, serialized value size = 16, headers = RecordHeaders(headers = [], isReadOnly = false), key = 1001, value = "Keyboard,34.23")
Message fetched : ConsumerRecord(topic = kafka.learning.orders, partition = 0, leaderEpoch = 0, offset = 1, CreateTime = 1776958371730, serialized key size = 4, serialized value size = 14, headers = RecordHeaders(headers = [], isReadOnly = false), key = 1001, value = "Mouse, 23.64")
Message fetched : ConsumerRecord(topic = kafka.learning.orders, partition = 0, leaderEpoch = 0, offset = 2, CreateTime = 1776963966478, serialized key size = 4, serialized value size = 14, headers = RecordHeaders(headers = [], isReadOnly = false), key = 1007, value =  "RAM, 564.23")
Message fetched : ConsumerRecord(topic = kafka.learning.orders, partition = 0, leaderEpoch = 0, offset = 3, CreateTime = 1776969412624, serialized key size = 3, serialized value size = 19, headers = RecordHeaders(headers = [], isReadOnly = false), key = 998, value = This is order : 998)
Message fetched : ConsumerRecord(topic = kafka.learning.orders, partition = 0, leaderEpoch = 0, offset = 4, CreateTime = 1776969414624, serialized key size = 3, serialized value size = 19, headers = RecordHeaders(headers = [], isReadOnly = false), key = 999, value = This is order : 999)
Message fetched : ConsumerRecord(topic = kafka.learning.orders, partition = 0, leaderEpoch = 0, offset = 5, CreateTime = 1776969418627, serialized key size = 4, serialized value size = 20, headers = RecordHeaders(headers = [], isReadOnly = false), key = 1001, value = This is order : 1001)

*/