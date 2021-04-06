package com.application.pidev.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.application.pidev.Entity.In.PaymentIn;
import com.application.pidev.Entity.Out.PaymentOut;
import com.application.pidev.Service.Interfaces.PaymentService;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/payments")
@RestController
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public PaymentOut create(@RequestBody @Valid PaymentIn paymentIn) {
        return paymentService.create(paymentIn);
    }
    
    @PostMapping("/withdraw")
    public PaymentOut withdraw(@RequestBody @Valid PaymentIn paymentIn) {
        return paymentService.withdraw(paymentIn);
    }

    @GetMapping("/account/{id}")
    public List<PaymentOut> findByAccountId(@PathVariable("id") Long id) {
        return paymentService.findAllByBankAccountId(id);
    }

    @GetMapping
    public List<PaymentOut> findAll() {
        return paymentService.findAll();
    }
}