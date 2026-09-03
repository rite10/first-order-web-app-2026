package com.capgemini.paymentservice.service;

import java.util.List;

import com.capgemini.paymentservice.entity.Payment;

public interface PaymentServiceInf {
   public Payment processPayment(Payment payment);

    public Payment fetchPaymentById();
 
    public Payment fetchPaymentByOrderId();

    public Payment changePaymentStatus();
   
    public List<Payment> fetchAllPayments() ;
}
