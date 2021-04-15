package com.application.pidev.Entity.BankAccount.In;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

import com.application.pidev.Entity.BankAccount.enums.BankAccountType;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BankAccountIn {
    @NotNull
    private BankAccountType bankAccountType;
}
