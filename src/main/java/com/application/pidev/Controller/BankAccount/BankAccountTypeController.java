package com.application.pidev.Controller.BankAccount;


import com.application.pidev.Entity.BankAccount.Edit.*;
import com.application.pidev.Entity.BankAccount.In.*;
import com.application.pidev.Entity.BankAccount.Out.*;
import com.application.pidev.Service.BankAccount.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/bankaccounttypes")
public class BankAccountTypeController {
    private final BankAccTypeService bankAccTypeService;

    @Autowired
    public BankAccountTypeController(BankAccTypeService bankAccTypeService) {
        this.bankAccTypeService = bankAccTypeService;
    }

    @GetMapping
    public List<BankAccTypeOut> findAll() {
        return bankAccTypeService.findAll();
    }

    @PutMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public BankAccTypeOut update(@PathVariable Long id,
                                 @RequestBody @Valid BankAccTypeEdit bankAccTypeEdit) {
        return bankAccTypeService.update(id, bankAccTypeEdit);
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public BankAccTypeOut findById(@PathVariable("id") Long id) {
        return bankAccTypeService.findById(id);
    }
}
