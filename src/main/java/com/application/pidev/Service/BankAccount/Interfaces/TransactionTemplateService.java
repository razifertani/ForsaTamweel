package com.application.pidev.Service.Interfaces;

import java.util.List;

import com.application.pidev.Entity.In.TransactionTemplateIn;
import com.application.pidev.Entity.Out.TransactionTemplateOut;

public interface TransactionTemplateService {
    TransactionTemplateOut create(TransactionTemplateIn transactionTemplateIn);

    List<TransactionTemplateOut> findAll();

    TransactionTemplateOut findOneById(Long id);

    TransactionTemplateOut update(Long id, TransactionTemplateIn transactionTemplateIn);

    void deleteById(Long id);

    List<TransactionTemplateOut> findAllByCurrentUser();

}
