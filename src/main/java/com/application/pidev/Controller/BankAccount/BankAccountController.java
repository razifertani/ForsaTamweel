package com.application.pidev.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.application.pidev.Entity.Edit.BankAccountEdit;
import com.application.pidev.Entity.Edit.SaldoEdit;
import com.application.pidev.Entity.In.BankAccountIn;
import com.application.pidev.Entity.Out.BankAccountOut;
import com.application.pidev.Entity.Out.SaldoOut;
import com.application.pidev.Service.Interfaces.BankAccountService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/bankaccount")
public class BankAccountController {
    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping
    public List<BankAccountOut> findAll() {
        return bankAccountService.findAll();
    }

    @GetMapping("/byUser")
    public List<BankAccountOut> findByUser() {
        return bankAccountService.findByUser();
    }

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
                                 @RequestBody @Valid BankAccountEdit bankAccountEdit) {
        return bankAccountService.update(id, bankAccountEdit);
    }

    @PutMapping("/saldo/{id}")
    public SaldoOut update(@PathVariable("id") Long id,
                           @RequestBody @Valid SaldoEdit saldoEdit) {
        return bankAccountService.updateSaldo(id, saldoEdit);
    }

}
