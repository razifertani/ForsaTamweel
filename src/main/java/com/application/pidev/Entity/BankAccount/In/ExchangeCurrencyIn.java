package com.application.pidev.Entity.In;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import com.application.pidev.Entity.BankAccount;
import com.application.pidev.Entity.CurrencyType;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExchangeCurrencyIn {

    @Positive
    private float balance;

    @NotEmpty
    private String sourceBankAccNumber;

    @NotEmpty
    private String sourceCurrency;

    @NotEmpty
    private String destCurrency;
}
