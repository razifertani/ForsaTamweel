package com.application.pidev.Entity.BankAccount.mappers;

import org.mapstruct.Mapper;

import com.application.pidev.Entity.BankAccount.BankAccType;
import com.application.pidev.Entity.BankAccount.Out.BankAccTypeOut;

@Mapper (componentModel = "spring")
public interface BankAccTypeMapper
{
        BankAccTypeOut entityToDto ( BankAccType bankAccType );
}
