package com.Spring.KafkaAnnotation.controller;

import com.Spring.KafkaAnnotation.events.PaymentEvent;
import com.Spring.KafkaAnnotation.producer.PaymentProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

    private final PaymentProducer paymentProducer;

    public PaymentController(PaymentProducer paymentProducer) {
        this.paymentProducer = paymentProducer;
    }

    @PostMapping("/payments/send")
    public String sendPayment() {

        PaymentEvent event = new PaymentEvent(
                UUID.randomUUID().toString(),
                "CUST001",
                100.00,
                "COMPLETED"
        );

        paymentProducer.sendPaymentEvent(event);

        return "Payment event sent to Kafka";
    }
}