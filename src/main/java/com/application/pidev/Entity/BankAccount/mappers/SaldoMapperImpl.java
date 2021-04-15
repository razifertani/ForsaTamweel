package com.application.pidev.Entity.BankAccount.mappers;


import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.application.pidev.Entity.BankAccount.*;
import com.application.pidev.Entity.BankAccount.Out.*;
import com.application.pidev.Entity.BankAccount.In.*;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-13T11:27:26+0200",
    comments = "version: 1.2.0.Final, compiler: Eclipse JDT (IDE) 1.3.1100.v20200828-0941, environment: Java 14.0.2 (Oracle Corporation)"
)
@Component
public class SaldoMapperImpl implements SaldoMapper {

    @Autowired
    private CurrencyTypeMapper currencyTypeMapper;

    @Override
    public SaldoOut saldoToSaldoOut(Saldo saldo) {
        if ( saldo == null ) {
            return null;
        }

        SaldoOut saldoOut = new SaldoOut();

        saldoOut.setBalance( saldo.getBalance() );
        saldoOut.setCurrencyType( currencyTypeMapper.entityToDTO( saldo.getCurrencyType() ) );
        saldoOut.setId( saldo.getId() );

        return saldoOut;
    }
}
