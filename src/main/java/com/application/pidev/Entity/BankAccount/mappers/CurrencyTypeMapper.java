package com.application.pidev.Entity.BankAccount.mappers;


import org.mapstruct.Mapper;

import com.application.pidev.Entity.BankAccount.CurrencyType;
import com.application.pidev.Entity.BankAccount.In.CurrencyTypeIn;
import com.application.pidev.Entity.BankAccount.Out.CurrencyTypeOut;

@Mapper (componentModel = "spring")
public interface CurrencyTypeMapper
{
        CurrencyType DTOtoEntity ( CurrencyTypeIn currencyTypeIn );

        CurrencyTypeOut entityToDTO ( CurrencyType currencyType );
}