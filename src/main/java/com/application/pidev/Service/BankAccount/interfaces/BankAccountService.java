package com.application.pidev.Service.BankAccount.interfaces;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.application.pidev.Entity.BankAccount.Edit.BankAccountEdit;
import com.application.pidev.Entity.BankAccount.Edit.SaldoEdit;
import com.application.pidev.Entity.BankAccount.In.BankAccountIn;
import com.application.pidev.Entity.BankAccount.Out.BankAccountOut;
import com.application.pidev.Entity.BankAccount.Out.SaldoOut;
@Repository
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
