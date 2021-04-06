package com.application.pidev.Service.Interfaces;

import java.util.List;

import com.application.pidev.Entity.Transaction;
import com.application.pidev.Entity.In.TransactionIn;
import com.application.pidev.Entity.Out.TransactionOut;

public interface TransactionService {
    TransactionOut create(TransactionIn transactionDTO);
    
    // WithdrawOut withdraw (WithdrawIn withdrawIn);

    List<TransactionOut> findAll();

    List<TransactionOut> findAllByBankAccountId(Long bankAccountId);
}