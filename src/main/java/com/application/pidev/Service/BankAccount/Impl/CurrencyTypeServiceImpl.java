package com.application.pidev.Service.BankAccount.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.pidev.BankAccountSettings.Exceptions.ApiException;
import com.application.pidev.Entity.BankAccount.CurrencyType;
import com.application.pidev.Entity.BankAccount.Edit.CurrencyTypeEdit;
import com.application.pidev.Entity.BankAccount.In.CurrencyTypeIn;
import com.application.pidev.Entity.BankAccount.Out.CurrencyTypeOut;
import com.application.pidev.Entity.BankAccount.mappers.CurrencyTypeMapper;
import com.application.pidev.Repository.BankAccount.CurrencyTypeRepository;
import com.application.pidev.Service.BankAccount.interfaces.CurrencyTypeService;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyTypeServiceImpl implements CurrencyTypeService {
    private final CurrencyTypeRepository currencyTypeRepository;

    private final CurrencyTypeMapper currencyTypeMapper;


    @Autowired
    public CurrencyTypeServiceImpl(CurrencyTypeRepository currencyTypeRepository,
                                   CurrencyTypeMapper currencyTypeMapper) {
        this.currencyTypeRepository = currencyTypeRepository;
        this.currencyTypeMapper = currencyTypeMapper;
    }

    @Override
    public List<CurrencyTypeOut> findAll() {
        return currencyTypeRepository.findAll()
            .stream()
            .map(currencyTypeMapper::entityToDTO)
            .collect(Collectors.toList());
    }

    @Override
    public CurrencyTypeOut create(@NotNull CurrencyTypeIn currencyTypeIn) {
        return null;
    }

    @Override
    public CurrencyTypeOut update(Long id, CurrencyTypeEdit currencyTypeEdit) {
        CurrencyType currencyType = currencyTypeRepository.findById(id)
            .orElseThrow(() -> new ApiException("Exception.notFound", null));

        currencyType.setName(currencyTypeEdit.getName().trim());
        currencyType.setExchangeRate(currencyTypeEdit.getExchangeRate());

        return currencyTypeMapper.entityToDTO(currencyTypeRepository.save(currencyType));
    }

    @Override
    public CurrencyTypeOut findById(Long id) {
        return currencyTypeMapper.entityToDTO(
            currencyTypeRepository.findById(id).orElseThrow(() -> new ApiException("Exception.notFound", null)));
    }
}
