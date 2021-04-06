package com.application.pidev.Entity.Out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import com.application.pidev.Entity.BankAccType;
import com.application.pidev.Entity.Saldo;
import com.application.pidev.Entity.Transaction;


@Data
public class BankAccountOut {
    private Long id;

    private String number;

    private BankAccTypeOut bankAccType;

    private Set<SaldoOut> saldos;

    private boolean removed;
}
