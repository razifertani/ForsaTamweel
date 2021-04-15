package com.application.pidev.Entity.BankAccount.mappers;
import com.application.pidev.Entity.BankAccount.*;
import com.application.pidev.Entity.BankAccount.Out.*;
import com.application.pidev.Entity.BankAccount.In.*;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-13T11:27:25+0200",
    comments = "version: 1.2.0.Final, compiler: Eclipse JDT (IDE) 1.3.1100.v20200828-0941, environment: Java 14.0.2 (Oracle Corporation)"
)
@Component
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public PaymentOut entityToDto(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        PaymentOut paymentOut = new PaymentOut();

        paymentOut.setBalance( payment.getBalance() );
        paymentOut.setDate( payment.getDate() );
        paymentOut.setDestinedBankAccount( bankAccountToBankAccountOut( payment.getDestinedBankAccount() ) );
        paymentOut.setId( payment.getId() );
        paymentOut.setSourceCurrencyType( currencyTypeToCurrencyTypeOut( payment.getSourceCurrencyType() ) );

        return paymentOut;
    }

    protected BankAccTypeOut bankAccTypeToBankAccTypeOut(BankAccType bankAccType) {
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

    protected SaldoOut saldoToSaldoOut(Saldo saldo) {
        if ( saldo == null ) {
            return null;
        }

        SaldoOut saldoOut = new SaldoOut();

        saldoOut.setBalance( saldo.getBalance() );
        saldoOut.setCurrencyType( currencyTypeToCurrencyTypeOut( saldo.getCurrencyType() ) );
        saldoOut.setId( saldo.getId() );

        return saldoOut;
    }

    protected Set<SaldoOut> saldoSetToSaldoOutSet(Set<Saldo> set) {
        if ( set == null ) {
            return null;
        }

        Set<SaldoOut> set1 = new HashSet<SaldoOut>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Saldo saldo : set ) {
            set1.add( saldoToSaldoOut( saldo ) );
        }

        return set1;
    }

    protected BankAccountOut bankAccountToBankAccountOut(BankAccount bankAccount) {
        if ( bankAccount == null ) {
            return null;
        }

        BankAccountOut bankAccountOut = new BankAccountOut();

        bankAccountOut.setBankAccType( bankAccTypeToBankAccTypeOut( bankAccount.getBankAccType() ) );
        bankAccountOut.setId( bankAccount.getId() );
        bankAccountOut.setNumber( bankAccount.getNumber() );
        bankAccountOut.setRemoved( bankAccount.isRemoved() );
        bankAccountOut.setSaldos( saldoSetToSaldoOutSet( bankAccount.getSaldos() ) );

        return bankAccountOut;
    }
}
