package com.application.pidev.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.application.pidev.Entity.ExchangeCurrency;
import com.application.pidev.Entity.In.ExchangeCurrencyIn;
import com.application.pidev.Entity.Out.ExchangeCurrencyOut;
import com.application.pidev.Service.Interfaces.ExchangeCurrencyService;

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
