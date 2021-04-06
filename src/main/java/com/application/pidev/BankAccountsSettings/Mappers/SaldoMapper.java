package com.application.pidev.BankAccountsSettings.Mappers;

import org.mapstruct.Mapper;

import com.application.pidev.Entity.Saldo;
import com.application.pidev.Entity.Out.SaldoOut;

@Mapper (componentModel = "spring", uses=CurrencyTypeMapper.class)
public interface SaldoMapper
{
        SaldoOut saldoToSaldoOut( Saldo saldo);
}
