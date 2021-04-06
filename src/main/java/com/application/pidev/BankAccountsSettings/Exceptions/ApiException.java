package com.application.pidev.BankAccountsSettings.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiException extends RuntimeException {
    private String message;
    private Object[] args;
}
