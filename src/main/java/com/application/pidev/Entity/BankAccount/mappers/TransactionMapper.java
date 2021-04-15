package com.application.pidev.Entity.BankAccount.mappers;

import org.mapstruct.Mapper;

import com.application.pidev.Entity.BankAccount.Transaction;
import com.application.pidev.Entity.BankAccount.Out.TransactionOut;

@Mapper(componentModel = "spring", uses = BankAccountMapper.class)
public interface TransactionMapper {
    TransactionOut entityToDTO(Transaction transaction);
}
