package com.application.pidev.Service.BankAccount.interfaces;


import java.util.List;

import com.application.pidev.Entity.BankAccount.Edit.CurrencyTypeEdit;
import com.application.pidev.Entity.BankAccount.In.CurrencyTypeIn;
import com.application.pidev.Entity.BankAccount.Out.CurrencyTypeOut;

public interface CurrencyTypeService {
    List<CurrencyTypeOut> findAll();

    CurrencyTypeOut create(CurrencyTypeIn currencyTypeIn);

    CurrencyTypeOut update(Long id, CurrencyTypeEdit currencyTypeEdit);

    CurrencyTypeOut findById(Long id);
}
