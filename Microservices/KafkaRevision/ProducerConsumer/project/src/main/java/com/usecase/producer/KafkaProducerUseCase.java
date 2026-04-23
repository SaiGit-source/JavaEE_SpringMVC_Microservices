package com.usecase.producer;

import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;


/* 
bin\windows\kafka-topics.bat --create --topic kafka.usecase.students --bootstrap-server localhost:9092 --partitions 2 --replication-factor 1
 */
/*
bin\windows\kafka-topics.bat --create --topic kafka.usecase.students --bootstrap-server localhost:9092 --partitions 2 --replication-factor 1
2026-04-23T19:40:39.059933600Z main ERROR Reconfiguration failed: No configuration found for '764c12b6' at 'null' in 'null'
WARNING: Due to limitations in metric names, topics with a period ('.') or underscore ('_') could collide. To avoid issues it is best to use either, but not both.
Created topic kafka.usecase.students.
*/
/*
.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --describe 
PS C:\Users\saito\Downloads\kafka> .\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --describe
2026-04-23T19:53:21.368504300Z main ERROR Reconfiguration failed: No configuration found for '764c12b6' at 'null' in 'null'
Topic: kafka.usecase.students   TopicId: SLQaIQbFQDK6vkU6lsk24g PartitionCount: 2       ReplicationFactor: 1    Configs: min.insync.replicas=1,segment.bytes=1073741824
        Topic: kafka.usecase.students   Partition: 0    Leader: 1       Replicas: 1     Isr: 1  Elr:    LastKnownElr: 
        Topic: kafka.usecase.students   Partition: 1    Leader: 1       Replicas: 1     Isr: 1  Elr:    LastKnownElr: 
*/

/*
bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list
S C:\Users\saito\Downloads\kafka> bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list
2026-04-23T19:53:42.624237Z main ERROR Reconfiguration failed: No configuration found for '764c12b6' at 'null' in 'null'
kafka.usecase.students
 */

/*
.\bin\windows\kafka-console-producer.bat --bootstrap-server localhost:9092 --topic kafka.usecase.students --property "parse.key=true" --property "key.separator=:"
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic kafka.usecase.students --group test-consumer-group --property print.key=true --property key.separator=" = " --from-beginning
*/

public class KafkaProducerUseCase {

    public KafkaProducerUseCase(Properties kafkaProps) {
    }

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
                                "kafka.usecase.students",    //Topic name
                                String.valueOf(i),          //Key for the message
                                "This is student : " + i         //Message Content
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
Sending Message : ProducerRecord(topic=kafka.usecase.students, partition=null, headers=RecordHeaders(headers = [], isReadOnly = false), key=168, value=This is student : 168, timestamp=null)
Sending Message : ProducerRecord(topic=kafka.usecase.students, partition=null, headers=RecordHeaders(headers = [], isReadOnly = false), key=169, value=This is student : 169, timestamp=null)
Sending Message : ProducerRecord(topic=kafka.usecase.students, partition=null, headers=RecordHeaders(headers = [], isReadOnly = false), key=170, value=This is student : 170, timestamp=null)
Sending Message : ProducerRecord(topic=kafka.usecase.students, partition=null, headers=RecordHeaders(headers = [], isReadOnly = false), key=171, value=This is student : 171, timestamp=null)
Sending Message : ProducerRecord(topic=kafka.usecase.students, partition=null, headers=RecordHeaders(headers = [], isReadOnly = false), key=172, value=This is student : 172, timestamp=null)
Sending Message : ProducerRecord(topic=kafka.usecase.students, partition=null, headers=RecordHeaders(headers = [], isReadOnly = false), key=173, value=This is student : 173, timestamp=null)
Sending Message : ProducerRecord(topic=kafka.usecase.students, partition=null, headers=RecordHeaders(headers = [], isReadOnly = false), key=174, value=This is student : 174, timestamp=null)
Sending Message : ProducerRecord(topic=kafka.usecase.students, partition=null, headers=RecordHeaders(headers = [], isReadOnly = false), key=175, value=This is student : 175, timestamp=null)

*/