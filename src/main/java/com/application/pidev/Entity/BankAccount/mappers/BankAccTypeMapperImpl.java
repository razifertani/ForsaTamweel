package com.application.pidev.Entity.BankAccount.mappers;

import com.application.pidev.Entity.BankAccount.*;
import com.application.pidev.Entity.BankAccount.Out.*;
import com.application.pidev.Entity.BankAccount.In.*;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-13T11:27:26+0200",
    comments = "version: 1.2.0.Final, compiler: Eclipse JDT (IDE) 1.3.1100.v20200828-0941, environment: Java 14.0.2 (Oracle Corporation)"
)
@Component
public class BankAccTypeMapperImpl implements BankAccTypeMapper {

    @Override
    public BankAccTypeOut entityToDto(BankAccType bankAccType) {
        if ( bankAccType == null ) {
            return null;
        }

        BankAccTypeOut bankAccTypeOut = new BankAccTypeOut();

        bankAccTypeOut.setBankAccountType( bankAccType.getBankAccountType() );
        bankAccTypeOut.setExchangeCurrencyCommission( bankAccType.getExchangeCurrencyCommission() );
        bankAccTypeOut.setId( bankAccType.getId() );
        bankAccTypeOut.setTransactionComission( bankAccType.getTransactionComission() );

        return bankAccTypeOut;
    }
}
