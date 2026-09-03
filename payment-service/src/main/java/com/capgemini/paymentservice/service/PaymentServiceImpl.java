package com.capgemini.paymentservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.paymentservice.entity.Payment;
import com.capgemini.paymentservice.repo.PaymentRepoInterface;

@Service
public class PaymentServiceImpl implements PaymentServiceInf {

    PaymentRepoInterface paymentRepo;

    public PaymentServiceImpl(PaymentRepoInterface paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    @Override
    public Payment processPayment(Payment payment) {
    Payment payments=paymentRepo.save(payment);
    return payments;
    }
    
    @Override
    public Payment fetchPaymentById() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fetchPaymentById'");
    }

    @Override
    public Payment fetchPaymentByOrderId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fetchPaymentByOrderId'");
    }

    @Override
    public Payment changePaymentStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changePaymentStatus'");
    }

    @Override
    public List<Payment> fetchAllPayments() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fetchAllPayments'");
    }


}
