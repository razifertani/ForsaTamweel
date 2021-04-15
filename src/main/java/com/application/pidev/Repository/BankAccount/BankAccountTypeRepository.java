package com.application.pidev.Repository.BankAccount;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.pidev.Entity.BankAccount.BankAccType;
import com.application.pidev.Entity.BankAccount.enums.BankAccountType;

public interface BankAccountTypeRepository extends JpaRepository<BankAccType, Long> {
    BankAccType findByBankAccountType(BankAccountType bankAccountType);
}
