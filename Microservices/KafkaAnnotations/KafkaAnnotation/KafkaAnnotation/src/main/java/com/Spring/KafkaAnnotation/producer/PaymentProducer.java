package com.Spring.KafkaAnnotation.producer;

import com.Spring.KafkaAnnotation.events.PaymentEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentProducer {

    private final KafkaTemplate<String, PaymentEvent> kafkaTemplate;

    public PaymentProducer(KafkaTemplate<String, PaymentEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPaymentEvent(PaymentEvent paymentEvent) {
        kafkaTemplate.send(
                "payment-events",
                paymentEvent.getPaymentId(),
                paymentEvent
        );

        System.out.println("Payment event sent to Kafka: " + paymentEvent.getPaymentId());
    }
}