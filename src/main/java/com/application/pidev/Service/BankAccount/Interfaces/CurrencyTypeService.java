package com.application.pidev.Service.Interfaces;

import java.util.List;

import com.application.pidev.Entity.Edit.CurrencyTypeEdit;
import com.application.pidev.Entity.In.CurrencyTypeIn;
import com.application.pidev.Entity.Out.CurrencyTypeOut;

public interface CurrencyTypeService {
    List<CurrencyTypeOut> findAll();

    CurrencyTypeOut create(CurrencyTypeIn currencyTypeIn);

    CurrencyTypeOut update(Long id, CurrencyTypeEdit currencyTypeEdit);

    CurrencyTypeOut findById(Long id);
}
