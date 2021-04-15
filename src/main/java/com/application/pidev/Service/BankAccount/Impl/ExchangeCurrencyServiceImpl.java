package com.application.pidev.Service.BankAccount.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.pidev.BankAccountSettings.Exceptions.ApiException;
import com.application.pidev.BankAccountSettings.Utils.Constants;
import com.application.pidev.BankAccountSettings.Utils.CurrencyConverter;
import com.application.pidev.Entity.BankAccount.*;
import com.application.pidev.Entity.BankAccount.In.ExchangeCurrencyIn;
import com.application.pidev.Entity.BankAccount.Out.ExchangeCurrencyOut;
import com.application.pidev.Entity.BankAccount.mappers.ExchangeCurrencyMapper;
import com.application.pidev.Repository.BankAccount.*;
import com.application.pidev.Service.BankAccount.interfaces.ExchangeCurrencyService;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

@Service
public class ExchangeCurrencyServiceImpl implements ExchangeCurrencyService {
    private final ExchangeCurrencyRepository exchangeCurrencyRepository;

    private final ExchangeCurrencyMapper exchangeCurrencyMapper;

    private final BankAccountRepository bankAccountRepository;

    private final CurrencyConverter currencyConverter;

    private final CurrencyTypeRepository currencyTypeRepository;

    private final Constants constants;

    @Autowired
    public ExchangeCurrencyServiceImpl(ExchangeCurrencyRepository exchangeCurrencyRepository,
                                       ExchangeCurrencyMapper exchangeCurrencyMapper,
                                       BankAccountRepository bankAccountRepository,
                                       CurrencyConverter currencyConverter,
                                       Constants constants,
                                       SaldoRepository saldoRepository,
                                       CurrencyTypeRepository currencyTypeRepository) {
        this.exchangeCurrencyRepository = exchangeCurrencyRepository;
        this.exchangeCurrencyMapper = exchangeCurrencyMapper;
        this.bankAccountRepository = bankAccountRepository;
        this.currencyConverter = currencyConverter;
        this.constants = constants;
        this.currencyTypeRepository = currencyTypeRepository;
    }

    @Override
    public ExchangeCurrencyOut create(@NotNull ExchangeCurrencyIn exchangeCurrencyIn) {
        BankAccount sourceBankAcc = bankAccountRepository.findByNumberAndRemovedFalse(exchangeCurrencyIn.getSourceBankAccNumber())
            .orElseThrow(() -> new RuntimeException("nie znaleziono"));

        Saldo sourceSaldo = sourceBankAcc.getSaldos()
            .stream()
            .filter(e -> Objects.equals(e.getCurrencyType().getName(), exchangeCurrencyIn.getSourceCurrency()))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("not found"));

        if (sourceSaldo.getBalance().doubleValue() < exchangeCurrencyIn.getBalance())
            throw new ApiException("Exception.notEnoughBalanceSaldo", null);


        Saldo destSaldo = sourceBankAcc.getSaldos()
            .stream()
            .filter(e -> Objects.equals(e.getCurrencyType().getName(), exchangeCurrencyIn.getDestCurrency()))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("not found"));


        ExchangeCurrency mapped = exchangeCurrencyMapper.DTOtoEntity(exchangeCurrencyIn);

        CurrencyType sourceCurrencyType = sourceSaldo.getCurrencyType();
        CurrencyType destCurrencyType = destSaldo.getCurrencyType();

        BigDecimal convertedBalance = currencyConverter.convertCurrency(
            mapped.getBalance(),
            sourceCurrencyType,
            destCurrencyType
        );

        float transactionCommission = sourceBankAcc.getBankAccType().getExchangeCurrencyCommission();
        BigDecimal balanceAfterCommission = BigDecimal.valueOf(
            convertedBalance.doubleValue() - ((transactionCommission / 100d) * convertedBalance.doubleValue()
            ));

        if (balanceAfterCommission.doubleValue() < 0)
            balanceAfterCommission = BigDecimal.ZERO;

        sourceSaldo.setBalance(sourceSaldo.getBalance().subtract(BigDecimal.valueOf(exchangeCurrencyIn.getBalance())));
        destSaldo.setBalance(destSaldo.getBalance().add(balanceAfterCommission));

        mapped.setBalanceAfterExchange(balanceAfterCommission);
        mapped.setBankAccount(sourceBankAcc);
        mapped.setDate(Instant.now());

        exchangeCurrencyRepository.save(mapped);
        return exchangeCurrencyMapper.entityToDTO(mapped);
    }

    @Override
    public BigDecimal calculate(ExchangeCurrencyIn exchangeCurrencyIn) {
        CurrencyType sourceCurrencyType = currencyTypeRepository.findByName(exchangeCurrencyIn.getSourceCurrency()).orElseThrow(() -> new RuntimeException("not found"));
        CurrencyType destCurrencyType = currencyTypeRepository.findByName(exchangeCurrencyIn.getDestCurrency()).orElseThrow(() -> new RuntimeException("Not found"));

        return currencyConverter.convertCurrency(
            exchangeCurrencyIn.getBalance(),
            sourceCurrencyType,
            destCurrencyType
        );
    }
}
