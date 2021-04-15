package com.application.pidev.Entity.BankAccount.Out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CurrencyTypeOut
{
        private Long id;

        private String name;

        private float exchangeRate;
}
