package com.application.pidev.Controller.BankAccount;


import com.application.pidev.Entity.BankAccount.Edit.*;
import com.application.pidev.Entity.BankAccount.In.*;
import com.application.pidev.Entity.BankAccount.Out.*;
import com.application.pidev.Service.BankAccount.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/exchangecurrency")
public class ExchangeCurrencyController {
    private final ExchangeCurrencyService exchangeCurrencyService;

    @Autowired
    public ExchangeCurrencyController(ExchangeCurrencyService exchangeCurrencyService) {
        this.exchangeCurrencyService = exchangeCurrencyService;
    }

    @PostMapping
    public ExchangeCurrencyOut create(@RequestBody ExchangeCurrencyIn exchangeCurrencyIn) {
        return exchangeCurrencyService.create(exchangeCurrencyIn);
    }

    @PostMapping("/calculate")
    public BigDecimal calculate(@RequestBody ExchangeCurrencyIn exchangeCurrencyIn) {
        return exchangeCurrencyService.calculate(exchangeCurrencyIn);
    }
}
