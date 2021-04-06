package com.application.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.pidev.Entity.Payment;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findAllByDestinedBankAccount_Id(Long bankAccountId);
}
