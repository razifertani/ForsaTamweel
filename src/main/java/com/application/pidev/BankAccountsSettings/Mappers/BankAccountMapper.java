package com.application.pidev.BankAccountsSettings.Mappers;

import org.mapstruct.Mapper;

import com.application.pidev.Entity.BankAccType;
import com.application.pidev.Entity.BankAccount;
import com.application.pidev.Entity.Out.BankAccountOut;

@Mapper(componentModel = "spring", uses = {SaldoMapper.class, BankAccTypeMapper.class})
public interface BankAccountMapper {
    BankAccountOut entityToDTO(BankAccount bankAccount);
}
