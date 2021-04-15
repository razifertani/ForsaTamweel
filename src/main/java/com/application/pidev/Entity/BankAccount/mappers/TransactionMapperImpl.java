package com.application.pidev.Entity.BankAccount.mappers;

import com.application.pidev.Entity.BankAccount.*;
import com.application.pidev.Entity.BankAccount.Out.*;
import com.application.pidev.Entity.BankAccount.In.*;

import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-13T11:27:25+0200",
    comments = "version: 1.2.0.Final, compiler: Eclipse JDT (IDE) 1.3.1100.v20200828-0941, environment: Java 14.0.2 (Oracle Corporation)"
)
@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Autowired
    private BankAccountMapper bankAccountMapper;

    @Override
    public TransactionOut entityToDTO(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        TransactionOut transactionOut = new TransactionOut();

        transactionOut.setBalance( transaction.getBalance() );
        transactionOut.setBalanceWithCommission( transaction.getBalanceWithCommission() );
        transactionOut.setDate( transaction.getDate() );
        transactionOut.setDestinedBankAccount( bankAccountMapper.entityToDTO( transaction.getDestinedBankAccount() ) );
        transactionOut.setDestinedCurrencyType( currencyTypeToCurrencyTypeOut( transaction.getDestinedCurrencyType() ) );
        transactionOut.setId( transaction.getId() );
        transactionOut.setSourceBankAccount( bankAccountMapper.entityToDTO( transaction.getSourceBankAccount() ) );
        transactionOut.setSourceCurrencyType( currencyTypeToCurrencyTypeOut( transaction.getSourceCurrencyType() ) );
        transactionOut.setTitle( transaction.getTitle() );

        return transactionOut;
    }

    protected CurrencyTypeOut currencyTypeToCurrencyTypeOut(CurrencyType currencyType) {
        if ( currencyType == null ) {
            return null;
        }

        CurrencyTypeOut currencyTypeOut = new CurrencyTypeOut();

        currencyTypeOut.setExchangeRate( currencyType.getExchangeRate() );
        currencyTypeOut.setId( currencyType.getId() );
        currencyTypeOut.setName( currencyType.getName() );

        return currencyTypeOut;
    }
}
