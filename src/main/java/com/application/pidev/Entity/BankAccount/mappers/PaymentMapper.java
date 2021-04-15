package com.application.pidev.Entity.BankAccount.mappers;

import org.mapstruct.Mapper;

import com.application.pidev.Entity.BankAccount.Payment;
import com.application.pidev.Entity.BankAccount.Out.PaymentOut;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentOut entityToDto(Payment payment);
}
