package com.application.pidev.Entity.Out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import com.application.pidev.Entity.CurrencyType;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExchangeCurrencyOut
{
        private BigDecimal balance;

        private String destCurrency;
}
