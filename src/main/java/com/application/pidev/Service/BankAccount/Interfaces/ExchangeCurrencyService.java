package com.application.pidev.Service.Interfaces;

import java.math.BigDecimal;

import com.application.pidev.Entity.In.ExchangeCurrencyIn;
import com.application.pidev.Entity.Out.ExchangeCurrencyOut;

public interface ExchangeCurrencyService
{
        ExchangeCurrencyOut create ( ExchangeCurrencyIn exchangeCurrencyIn );

        BigDecimal calculate(ExchangeCurrencyIn exchangeCurrencyIn);
}
