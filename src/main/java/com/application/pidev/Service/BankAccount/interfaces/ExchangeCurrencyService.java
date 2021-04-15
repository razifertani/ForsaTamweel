package com.application.pidev.Service.BankAccount.interfaces;


import java.math.BigDecimal;

import com.application.pidev.Entity.BankAccount.In.ExchangeCurrencyIn;
import com.application.pidev.Entity.BankAccount.Out.ExchangeCurrencyOut;

public interface ExchangeCurrencyService
{
        ExchangeCurrencyOut create ( ExchangeCurrencyIn exchangeCurrencyIn );

        BigDecimal calculate(ExchangeCurrencyIn exchangeCurrencyIn);
}
