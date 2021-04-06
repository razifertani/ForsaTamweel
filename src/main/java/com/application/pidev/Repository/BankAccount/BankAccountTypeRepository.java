package com.application.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.pidev.Entity.BankAccType;
import com.application.pidev.Entity.Enums.BankAccountType;

public interface BankAccountTypeRepository extends JpaRepository<BankAccType, Long> {
    BankAccType findByBankAccountType(BankAccountType bankAccountType);
}
