package com.application.pidev.Entity.BankAccount.Out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionOut
{
        private Long id;

        private Instant date;

        private BigDecimal balance;

        private BigDecimal balanceWithCommission;

        private BankAccountOut sourceBankAccount;

        private String title;

        private BankAccountOut destinedBankAccount;

        private CurrencyTypeOut sourceCurrencyType;

        private CurrencyTypeOut destinedCurrencyType;
}
