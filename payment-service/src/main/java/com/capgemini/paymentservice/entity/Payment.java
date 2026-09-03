package com.capgemini.paymentservice.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private Long orderId;

    private Double amount;

    private String paymentMethod;

    private String paymentStatus;

    private String transactionId;

    private LocalDateTime paymentDate;

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Payment [paymentId=" + paymentId + ", orderId=" + orderId + ", amount=" + amount + ", paymentMethod="
                + paymentMethod + ", paymentStatus=" + paymentStatus + ", transactionId=" + transactionId
                + ", paymentDate=" + paymentDate + ", getPaymentId()=" + getPaymentId() + ", getOrderId()="
                + getOrderId() + ", getAmount()=" + getAmount() + ", getPaymentMethod()=" + getPaymentMethod()
                + ", getPaymentStatus()=" + getPaymentStatus() + ", getTransactionId()=" + getTransactionId()
                + ", getClass()=" + getClass() + ", getPaymentDate()=" + getPaymentDate() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
    }
    
    
}
