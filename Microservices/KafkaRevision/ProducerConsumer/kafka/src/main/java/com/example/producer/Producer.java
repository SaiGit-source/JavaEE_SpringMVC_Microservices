package com.example.producer;

import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;


public class Producer {

        public static void main(String[] args) {

        //Setup Properties for Kafka Producer
        Properties kafkaProps = new Properties();

        //List of brokers to connect to
        kafkaProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                            "localhost:9092");

        //Serializer class used to convert Keys to Byte Arrays
        kafkaProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                            "org.apache.kafka.common.serialization.StringSerializer");

        //Serializer class used to convert Messages to Byte Arrays
        kafkaProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                            "org.apache.kafka.common.serialization.StringSerializer");

        //Create a Kafka producer from configuration
        KafkaProducer simpleProducer = new KafkaProducer(kafkaProps);

        //Publish 10 messages at 2 second intervals, with a random key
        try{

            int startKey = (new Random()).nextInt(1000) ;

            for( int i=startKey; i < startKey + 10; i++) {

                //Create a producer Record
                ProducerRecord<String,String> kafkaRecord =
                        new ProducerRecord<String,String>(
                                "kafka.learning.orders",    //Topic name
                                String.valueOf(i),          //Key for the message
                                "This is order : " + i         //Message Content
                        );

                System.out.println("Sending Message : "+ kafkaRecord.toString());

                //Publish to Kafka
                simpleProducer.send(kafkaRecord);

                Thread.sleep(2000);
            }
        }
        catch(Exception e) {

        }
        finally {
            simpleProducer.close();
        }

    }

}

/* Output
Sending Message : ProducerRecord(topic=kafka.learning.orders, partition=null, headers=RecordHeaders(headers = [], isReadOnly = false), key=992, value=This is order : 992, timestamp=null)
Sending Message : ProducerRecord(topic=kafka.learning.orders, partition=null, headers=RecordHeaders(headers = [], isReadOnly = false), key=993, value=This is order : 993, timestamp=null)
Sending Message : ProducerRecord(topic=kafka.learning.orders, partition=null, headers=RecordHeaders(headers = [], isReadOnly = false), key=994, value=This is order : 994, timestamp=null)
Sending Message : ProducerRecord(topic=kafka.learning.orders, partition=null, headers=RecordHeaders(headers = [], isReadOnly = false), key=995, value=This is order : 995, timestamp=null)
Sending Message : ProducerRecord(topic=kafka.learning.orders, partition=null, headers=RecordHeaders(headers = [], isReadOnly = false), key=996, value=This is order : 996, timestamp=null)
Sending Message : ProducerRecord(topic=kafka.learning.orders, partition=null, headers=RecordHeaders(headers = [], isReadOnly = false), key=997, value=This is order : 997, timestamp=null)
Sending Message : ProducerRecord(topic=kafka.learning.orders, partition=null, headers=RecordHeaders(headers = [], isReadOnly = false), key=998, value=This is order : 998, timestamp=null)
Sending Message : ProducerRecord(topic=kafka.learning.orders, partition=null, headers=RecordHeaders(headers = [], isReadOnly = false), key=999, value=This is order : 999, timestamp=null)
Sending Message : ProducerRecord(topic=kafka.learning.orders, partition=null, headers=RecordHeaders(headers = [], isReadOnly = false), key=1000, value=This is order : 1000, timestamp=null)
Sending Message : ProducerRecord(topic=kafka.learning.orders, partition=null, headers=RecordHeaders(headers = [], isReadOnly = false), key=1001, value=This is order : 1001, timestamp=null) 
*/