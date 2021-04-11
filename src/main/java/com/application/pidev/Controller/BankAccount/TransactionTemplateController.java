package com.application.pidev.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.application.pidev.Entity.TransactionTemplate;
import com.application.pidev.Entity.In.TransactionTemplateIn;
import com.application.pidev.Entity.Out.TransactionTemplateOut;
import com.application.pidev.Repository.TransactionTemplateRepository;
import com.application.pidev.Service.Interfaces.TransactionService;
import com.application.pidev.Service.Interfaces.TransactionTemplateService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/transactiontemplates")
public class TransactionTemplateController {
    private final TransactionTemplateService transactionTemplateService;

    @Autowired
    public TransactionTemplateController(TransactionTemplateService transactionTemplateService) {
        this.transactionTemplateService = transactionTemplateService;
    }

    @PostMapping
    @Secured("ROLE_USER")
    public TransactionTemplateOut create(@RequestBody @Valid TransactionTemplateIn transactionTemplateIn) {
        return transactionTemplateService.create(transactionTemplateIn);
    }

    @GetMapping
    @Secured("ROLE_USER")
    public List<TransactionTemplateOut> findAll() {
        return transactionTemplateService.findAll();
    }

    @GetMapping("/{id}")
    @Secured("ROLE_USER")
    public TransactionTemplateOut findOneById(@PathVariable("id") Long id) {
        return transactionTemplateService.findOneById(id);
    }

    @PutMapping("/{id}")
    @Secured("ROLE_USER")
    public TransactionTemplateOut updateById(@PathVariable("id") Long id,
                                             @RequestBody @Valid TransactionTemplateIn transactionTemplateIn) {
        return transactionTemplateService.update(id, transactionTemplateIn);
    }

    @GetMapping("/users/all")
    @Secured("ROLE_USER")
    public List<TransactionTemplateOut> findAllByCurrentUser() {
        return transactionTemplateService.findAllByCurrentUser();
    }


    @DeleteMapping("/{id}")
    @Secured("ROLE_USER")
    public void deleteById(@PathVariable("id") Long id) {
        transactionTemplateService.deleteById(id);
    }
}
