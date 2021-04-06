package com.application.pidev.Service.Interfaces;

import java.util.List;

import com.application.pidev.Entity.Edit.BankAccountEdit;
import com.application.pidev.Entity.Edit.SaldoEdit;
import com.application.pidev.Entity.In.BankAccountIn;
import com.application.pidev.Entity.Out.BankAccountOut;
import com.application.pidev.Entity.Out.SaldoOut;

public interface BankAccountService {
    BankAccountOut create(BankAccountIn bankAccountIn, String Username);

    List<BankAccountOut> findAll();

    List<BankAccountOut> findByUser();

    BankAccountOut findById(Long id);

    Long findBankAccountCountByType(Long id);

    void deleteById(Long id);

    BankAccountOut update(Long id, BankAccountEdit bankAccountEdit);

    SaldoOut updateSaldo(Long id, SaldoEdit saldoEdit);

}
