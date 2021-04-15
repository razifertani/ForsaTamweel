package com.application.pidev.Entity.BankAccount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import com.application.pidev.Entity.BankAccount.enums.BankAccountType;

@Entity
@Table (name = "bank_account_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccType
{
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Long id;

        @Enumerated (EnumType.STRING)
        @Column (name = "bank_account_type")
        private BankAccountType bankAccountType;

        @Column (name = "transaction_commission")
        private Float transactionComission;

        @Column (name = "exchange_currency_commission")
        private Float exchangeCurrencyCommission;
}
