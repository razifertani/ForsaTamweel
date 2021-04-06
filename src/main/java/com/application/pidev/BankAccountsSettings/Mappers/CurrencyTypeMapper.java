package com.application.pidev.BankAccountsSettings.Mappers;

import org.mapstruct.Mapper;

import com.application.pidev.Entity.CurrencyType;
import com.application.pidev.Entity.In.CurrencyTypeIn;
import com.application.pidev.Entity.Out.CurrencyTypeOut;

@Mapper (componentModel = "spring")
public interface CurrencyTypeMapper
{
        CurrencyType DTOtoEntity ( CurrencyTypeIn currencyTypeIn );

        CurrencyTypeOut entityToDTO ( CurrencyType currencyType );
}