package com.application.pidev.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.application.pidev.Entity.Transaction;
import com.application.pidev.Entity.In.TransactionIn;
import com.application.pidev.Entity.Out.TransactionOut;
import com.application.pidev.Service.Interfaces.TransactionService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public TransactionOut create(@Valid @RequestBody TransactionIn transactionIn) {
        return transactionService.create(transactionIn);
    }

    @GetMapping
    public List<TransactionOut> findAll() {
        return transactionService.findAll();
    }

    @GetMapping("/byAccount/{id}")
    public List<TransactionOut> findAllByBankAccountId(@PathVariable("id") Long id) {
        return transactionService.findAllByBankAccountId(id);
    }
}
