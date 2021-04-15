package com.application.pidev.Entity.BankAccount.mappers;

import org.mapstruct.Mapper;

import com.application.pidev.Entity.BankAccount.ExchangeCurrency;
import com.application.pidev.Entity.BankAccount.In.ExchangeCurrencyIn;
import com.application.pidev.Entity.BankAccount.Out.ExchangeCurrencyOut;

@Mapper (componentModel = "spring")
public interface ExchangeCurrencyMapper
{
        ExchangeCurrency DTOtoEntity ( ExchangeCurrencyIn exchangeCurrencyIn );

        ExchangeCurrencyOut entityToDTO ( ExchangeCurrency exchangeCurrency );
}
