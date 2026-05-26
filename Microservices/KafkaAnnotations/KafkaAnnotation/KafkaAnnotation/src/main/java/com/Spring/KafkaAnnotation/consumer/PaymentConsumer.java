package com.Spring.KafkaAnnotation.consumer;

import com.Spring.KafkaAnnotation.events.PaymentEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {

    @KafkaListener(
            topics = "payment-events",
            groupId = "payment-notification-group"
    )
    public void consumePaymentEvent(PaymentEvent paymentEvent) {

        System.out.println("Received payment event from Kafka:");
        System.out.println("Payment ID: " + paymentEvent.getPaymentId());
        System.out.println("Customer ID: " + paymentEvent.getCustomerId());
        System.out.println("Amount: " + paymentEvent.getAmount());
        System.out.println("Status: " + paymentEvent.getStatus());

        if ("COMPLETED".equals(paymentEvent.getStatus())) {
            System.out.println("Notification sent to customer.");
        }
    }
}