package com.application.pidev.Service.BankAccount.interfaces;



import java.util.List;

import com.application.pidev.Entity.BankAccount.In.TransactionIn;
import com.application.pidev.Entity.BankAccount.Out.TransactionOut;

public interface TransactionService {
    TransactionOut create(TransactionIn transactionDTO);
    
    // WithdrawOut withdraw (WithdrawIn withdrawIn);

    List<TransactionOut> findAll();

    List<TransactionOut> findAllByBankAccountId(Long bankAccountId);
}