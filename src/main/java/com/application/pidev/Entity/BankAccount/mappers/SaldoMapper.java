package com.application.pidev.Entity.BankAccount.mappers;

import org.mapstruct.Mapper;

import com.application.pidev.Entity.BankAccount.Saldo;
import com.application.pidev.Entity.BankAccount.Out.SaldoOut;

@Mapper (componentModel = "spring", uses=CurrencyTypeMapper.class)
public interface SaldoMapper
{
        SaldoOut saldoToSaldoOut( Saldo saldo);
}
