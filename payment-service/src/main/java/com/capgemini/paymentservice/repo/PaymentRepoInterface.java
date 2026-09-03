package com.capgemini.paymentservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.paymentservice.entity.Payment;

@Repository
public interface PaymentRepoInterface extends JpaRepository<Payment,Long>{

}
