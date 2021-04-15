package com.application.pidev.Service.BankAccount.interfaces;


import java.util.List;

import com.application.pidev.Entity.BankAccount.In.PaymentIn;
import com.application.pidev.Entity.BankAccount.Out.PaymentOut;

public interface PaymentService {
    PaymentOut create(PaymentIn paymentIn);
    
    PaymentOut withdraw(PaymentIn paymentIn);

    List<PaymentOut> findAllByBankAccountId(Long bankAccountId);

    List<PaymentOut> findAll();
}
