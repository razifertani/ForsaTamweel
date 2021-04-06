package com.application.pidev.BankAccountsSettings.Utils;

import java.math.BigDecimal;

import com.application.pidev.Entity.CurrencyType;

public interface CurrencyConverter
{
        BigDecimal convertCurrency ( float currency, CurrencyType sourceCurrency, CurrencyType destinedCurrency );
}
