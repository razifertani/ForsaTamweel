package com.application.pidev.BankAccountsSettings.Mappers;

import org.mapstruct.Mapper;

import com.application.pidev.Entity.TransactionTemplate;
import com.application.pidev.Entity.In.TransactionTemplateIn;
import com.application.pidev.Entity.Out.TransactionTemplateOut;

@Mapper (componentModel = "spring")
public interface TransactionTemplateMapper
{
        TransactionTemplateOut entityToDTO ( TransactionTemplate transactionTemplate );

        TransactionTemplate DTOtoEntity ( TransactionTemplateIn transactionTemplateIn );
}
