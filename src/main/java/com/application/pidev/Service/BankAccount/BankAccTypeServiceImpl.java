package com.application.pidev.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.pidev.BankAccountsSettings.Exceptions.ApiException;
import com.application.pidev.BankAccountsSettings.Mappers.BankAccTypeMapper;
import com.application.pidev.BankAccountsSettings.Mappers.BankAccountMapper;
import com.application.pidev.Entity.BankAccType;
import com.application.pidev.Entity.Edit.BankAccTypeEdit;
import com.application.pidev.Entity.Out.BankAccTypeOut;
import com.application.pidev.Repository.BankAccountTypeRepository;
import com.application.pidev.Service.Interfaces.BankAccTypeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankAccTypeServiceImpl implements BankAccTypeService {
    private final BankAccountTypeRepository bankAccountTypeRepository;

    private final BankAccTypeMapper bankAccTypeMapper;

    @Autowired
    public BankAccTypeServiceImpl(BankAccountTypeRepository bankAccountTypeRepository,
                                  BankAccTypeMapper bankAccTypeMapper) {
        this.bankAccountTypeRepository = bankAccountTypeRepository;
        this.bankAccTypeMapper = bankAccTypeMapper;
    }

    @Override
    public List<BankAccTypeOut> findAll() {
        return bankAccountTypeRepository.findAll()
            .stream()
            .map(bankAccTypeMapper::entityToDto)
            .collect(Collectors.toList());
    }

    @Override
    public BankAccTypeOut update(Long id, BankAccTypeEdit bankAccTypeEdit) {
        BankAccType bankAccType = bankAccountTypeRepository.findById(id)
            .orElseThrow(() -> new ApiException("Exception.notFound", null));

        bankAccType.setExchangeCurrencyCommission(bankAccTypeEdit.getExchangeCurrencyCommission().floatValue());
        bankAccType.setTransactionComission(bankAccTypeEdit.getTransactionComission().floatValue());

        return bankAccTypeMapper.entityToDto(bankAccountTypeRepository.save(bankAccType));
    }

    @Override
    public BankAccTypeOut findById(Long id) {
        return bankAccTypeMapper.entityToDto(
            bankAccountTypeRepository.findById(id).orElseThrow(() -> new ApiException("Exception.notFound", null))
        );
    }
}
