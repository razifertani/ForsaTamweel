package com.application.pidev.BankAccountsSettings.Mappers;

import org.mapstruct.Mapper;

import com.application.pidev.Entity.Transaction;
import com.application.pidev.Entity.In.TransactionIn;
import com.application.pidev.Entity.Out.TransactionOut;

@Mapper(componentModel = "spring", uses = BankAccountMapper.class)
public interface TransactionMapper {
    TransactionOut entityToDTO(Transaction transaction);
}
