package com.application.pidev.Entity.BankAccount.Out;

import com.application.pidev.Entity.BankAccount.enums.BankAccountType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccTypeOut {
    private Long id;

    private BankAccountType bankAccountType;

    private Float transactionComission;

    private Float exchangeCurrencyCommission;
}
