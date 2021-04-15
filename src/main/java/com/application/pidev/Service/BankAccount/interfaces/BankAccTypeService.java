package com.application.pidev.Service.BankAccount.interfaces;


import java.util.List;

import com.application.pidev.Entity.BankAccount.Edit.BankAccTypeEdit;
import com.application.pidev.Entity.BankAccount.Out.BankAccTypeOut;

public interface BankAccTypeService {
    List<BankAccTypeOut> findAll();

    BankAccTypeOut update(Long id, BankAccTypeEdit bankAccTypeEdit);

    BankAccTypeOut findById(Long id);
}
