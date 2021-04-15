package com.application.pidev.Controller.BankAccount;


import com.application.pidev.Entity.BankAccount.Edit.*;
import com.application.pidev.Entity.BankAccount.In.*;
import com.application.pidev.Entity.BankAccount.Out.*;
import com.application.pidev.Service.BankAccount.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
	@Autowired
      TransactionService transactionService;

    
		/*
		 * public TransactionController(TransactionService transactionService) {
		 * this.transactionService = transactionService; }
		 */

    @PostMapping
    public TransactionOut create( @RequestBody TransactionIn transactionIn) {
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
