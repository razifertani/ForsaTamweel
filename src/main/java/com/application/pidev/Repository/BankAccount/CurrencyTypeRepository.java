package com.application.pidev.Repository.BankAccount;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.pidev.Entity.BankAccount.CurrencyType;

import java.util.Optional;

public interface CurrencyTypeRepository extends JpaRepository<CurrencyType, Long>
{
        Optional<CurrencyType> findByName ( String name );

}
