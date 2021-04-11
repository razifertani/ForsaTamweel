package com.application.pidev.BankAccountsSettings.Mappers;

import org.mapstruct.Mapper;

import com.application.pidev.Entity.ExchangeCurrency;
import com.application.pidev.Entity.In.ExchangeCurrencyIn;
import com.application.pidev.Entity.Out.ExchangeCurrencyOut;

@Mapper (componentModel = "spring")
public interface ExchangeCurrencyMapper
{
        ExchangeCurrency DTOtoEntity ( ExchangeCurrencyIn exchangeCurrencyIn );

        ExchangeCurrencyOut entityToDTO ( ExchangeCurrency exchangeCurrency );
}
