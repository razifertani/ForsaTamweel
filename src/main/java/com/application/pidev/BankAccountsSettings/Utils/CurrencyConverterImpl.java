package com.application.pidev.BankAccountsSettings.Utils;

import org.springframework.stereotype.Component;

import com.application.pidev.Entity.CurrencyType;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class CurrencyConverterImpl implements CurrencyConverter {
    @Override
    public BigDecimal convertCurrency(float currency, CurrencyType sourceCurrency, CurrencyType destinedCurrency) {

        BigDecimal convertedCurrency;
        if (currency > 0) {
            if (sourceCurrency != null && destinedCurrency != null) {
                if (sourceCurrency == destinedCurrency) {
                    convertedCurrency = new BigDecimal(currency);
                    convertedCurrency = convertedCurrency.setScale(2, RoundingMode.DOWN);
                    return convertedCurrency;
                } else {
                    final float sourceExchangeRate = sourceCurrency.getExchangeRate();
                    final float destinedExchangeRate = destinedCurrency.getExchangeRate();
                    if (destinedExchangeRate > 0) {
                        convertedCurrency = new BigDecimal((currency * sourceExchangeRate) / destinedExchangeRate);
                        convertedCurrency = convertedCurrency.setScale(2, RoundingMode.DOWN);
                        return convertedCurrency;
                    }
                }
            }
        }
        return BigDecimal.ZERO;

    }
}
