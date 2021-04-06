package com.application.pidev.Entity.In;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.CurrencyType;
import org.hibernate.validator.constraints.Length;

import com.application.pidev.BankAccountsSettings.Utils.validators.BankAccountExists;
import com.application.pidev.Entity.BankAccount;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionIn {
    private String sourceAccountNumber;

    @NotBlank
    private String sourceCurrency;

    private String destinedAccountNumber;

    @NotBlank
    private String destinedCurrency;

    @Min(1)
    @Max(1000000)
    private float balance;

    @Length(min = 1, max = 100)
    @NotBlank
    private String title;
}
