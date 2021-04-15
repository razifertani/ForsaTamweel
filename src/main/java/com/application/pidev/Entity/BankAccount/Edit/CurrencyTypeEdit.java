package com.application.pidev.Entity.BankAccount.Edit;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CurrencyTypeEdit {
    private Long id;
    private String name;
    private float exchangeRate;
}
