package com.application.pidev.BankAccountsSettings.Mappers;

import org.mapstruct.Mapper;

import com.application.pidev.Entity.Payment;
import com.application.pidev.Entity.Out.PaymentOut;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentOut entityToDto(Payment payment);
}
