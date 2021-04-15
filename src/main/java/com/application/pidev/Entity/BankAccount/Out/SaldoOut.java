package com.application.pidev.Entity.BankAccount.Out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaldoOut
{
        private Long id;

        private CurrencyTypeOut currencyType;

        private BigDecimal balance;
}
