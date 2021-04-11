package com.application.pidev.Service.Interfaces;

import java.util.List;

import com.application.pidev.Entity.Edit.BankAccTypeEdit;
import com.application.pidev.Entity.Out.BankAccTypeOut;

public interface BankAccTypeService {
    List<BankAccTypeOut> findAll();

    BankAccTypeOut update(Long id, BankAccTypeEdit bankAccTypeEdit);

    BankAccTypeOut findById(Long id);
}
