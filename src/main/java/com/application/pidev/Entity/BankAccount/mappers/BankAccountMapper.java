package com.application.pidev.Entity.BankAccount.mappers;


import org.mapstruct.Mapper;

import com.application.pidev.Entity.BankAccount.BankAccount;
import com.application.pidev.Entity.BankAccount.Out.BankAccountOut;

@Mapper(componentModel = "spring", uses = {SaldoMapper.class, BankAccTypeMapper.class})
public interface BankAccountMapper {
    BankAccountOut entityToDTO(BankAccount bankAccount);
}
