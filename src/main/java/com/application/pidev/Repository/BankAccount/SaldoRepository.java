package com.application.pidev.Repository.BankAccount;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.pidev.Entity.BankAccount.Saldo;

public interface SaldoRepository extends JpaRepository<Saldo, Long> {

}
