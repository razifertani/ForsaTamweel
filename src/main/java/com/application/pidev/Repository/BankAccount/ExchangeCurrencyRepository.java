package com.application.pidev.Repository.BankAccount;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.pidev.Entity.BankAccount.ExchangeCurrency;

public interface ExchangeCurrencyRepository extends JpaRepository<ExchangeCurrency, Long>
{
}
