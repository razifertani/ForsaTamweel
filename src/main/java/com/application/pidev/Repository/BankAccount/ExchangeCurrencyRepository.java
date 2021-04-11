package com.application.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.pidev.Entity.ExchangeCurrency;

public interface ExchangeCurrencyRepository extends JpaRepository<ExchangeCurrency, Long>
{
}
