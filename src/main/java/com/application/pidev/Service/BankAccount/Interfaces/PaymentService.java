package com.application.pidev.Service.Interfaces;

import java.util.List;

import com.application.pidev.Entity.In.PaymentIn;
import com.application.pidev.Entity.Out.PaymentOut;

public interface PaymentService {
    PaymentOut create(PaymentIn paymentIn);
    
    PaymentOut withdraw(PaymentIn paymentIn);

    List<PaymentOut> findAllByBankAccountId(Long bankAccountId);

    List<PaymentOut> findAll();
}
