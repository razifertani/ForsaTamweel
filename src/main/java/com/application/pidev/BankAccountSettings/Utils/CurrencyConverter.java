package com.application.pidev.BankAccountSettings.Utils;


import java.math.BigDecimal;

import com.application.pidev.Entity.BankAccount.CurrencyType;

public interface CurrencyConverter
{
        BigDecimal convertCurrency ( float currency, CurrencyType sourceCurrency, CurrencyType destinedCurrency );
}
