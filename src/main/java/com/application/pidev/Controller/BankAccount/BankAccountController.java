package com.application.pidev.Controller.BankAccount;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import com.application.pidev.Entity.BankAccount.Edit.*;
import com.application.pidev.Entity.BankAccount.In.*;
import com.application.pidev.Entity.BankAccount.Out.*;
import com.application.pidev.Service.BankAccount.interfaces.BankAccountService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/bankaccount")

public class BankAccountController {
    @Autowired
      BankAccountService bankAccountService;

	/*
	 * @Autowired public BankAccountController(BankAccountService
	 * bankAccountService) { this.bankAccountService = bankAccountService; }
	 */

    @GetMapping
    public List<BankAccountOut> findAll() {
        return bankAccountService.findAll();
    }

    @GetMapping("/byUser")
    public List<BankAccountOut> findByUser() {
        return bankAccountService.findByUser();
    }
//chniya aaa l mochkel 
    @PostMapping("/add/{username}")
    public BankAccountOut create(@RequestBody BankAccountIn bankAccountIn,
    @PathVariable ("username") String username  ) {
        return bankAccountService.create(bankAccountIn, username);
    }

    @GetMapping("/{id}")
    public BankAccountOut findById(@PathVariable("id") Long id) {
        return bankAccountService.findById(id);
    }

    @GetMapping("/{id}/accountCount")
    public Long getBankAccountCountByType(@PathVariable("id") Long id) {
        return bankAccountService.findBankAccountCountByType(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        bankAccountService.deleteById(id);
    }

    @PutMapping("/{id}")
    public BankAccountOut update(@PathVariable("id") Long id,
                                 @RequestBody  BankAccountEdit bankAccountEdit) {
        return bankAccountService.update(id, bankAccountEdit);
    }

    @PutMapping("/saldo/{id}")
    public SaldoOut update(@PathVariable("id") Long id,
                           @RequestBody  SaldoEdit saldoEdit) {
        return bankAccountService.updateSaldo(id, saldoEdit);
    }

}
