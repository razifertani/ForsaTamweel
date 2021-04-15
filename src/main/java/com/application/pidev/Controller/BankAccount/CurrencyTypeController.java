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
@RequestMapping("/api/currencytype")
public class CurrencyTypeController {
    private final CurrencyTypeService currencyTypeService;

    @Autowired
    public CurrencyTypeController(CurrencyTypeService currencyTypeService) {
        this.currencyTypeService = currencyTypeService;
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<CurrencyTypeOut> findAll() {
        return currencyTypeService.findAll();
    }

    @PutMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public CurrencyTypeOut update(@RequestBody @Valid CurrencyTypeEdit currencyTypeEdit,
                                  @PathVariable("id") Long id){
        return currencyTypeService.update(id, currencyTypeEdit);
    }

    @GetMapping("/{id}")
    public CurrencyTypeOut findById(@PathVariable("id") Long id){
        return currencyTypeService.findById(id);
    }
}
