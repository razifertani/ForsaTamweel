package com.application.pidev.BankAccountsSettings.Mappers;

import org.mapstruct.Mapper;

import com.application.pidev.Entity.BankAccType;
import com.application.pidev.Entity.Out.BankAccTypeOut;

@Mapper (componentModel = "spring")
public interface BankAccTypeMapper
{
        BankAccTypeOut entityToDto ( BankAccType bankAccType );
}
