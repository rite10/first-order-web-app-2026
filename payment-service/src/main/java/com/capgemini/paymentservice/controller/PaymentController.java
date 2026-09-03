package com.capgemini.paymentservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.paymentservice.entity.Payment;
import com.capgemini.paymentservice.service.PaymentServiceImpl;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    PaymentServiceImpl paymentService;

    public PaymentController(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }
    
    @PostMapping("/add")
    public ResponseEntity<String> createPayment(
            @RequestBody Payment payment) {

        Payment savedPayment = paymentService.processPayment(payment);

        return new ResponseEntity<>(
                "Payment created with id :: " + savedPayment.getPaymentId(),
                HttpStatus.CREATED);
    }


    public Payment getPaymentById() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPaymentById'");
    }

    public Payment getPaymentByOrderId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPaymentByOrderId'");
    }

    public Payment updatePaymentStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePaymentStatus'");
    }

    public List<Payment> getAllPayments() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPayments'");
    }
}
