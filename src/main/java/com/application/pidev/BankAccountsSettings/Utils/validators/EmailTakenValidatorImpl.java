package com.application.pidev.BankAccountsSettings.Utils.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.application.pidev.Repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class EmailTakenValidatorImpl implements ConstraintValidator<EmailTaken, String> {
    private final UserRepository userRepository;

    @Autowired
    public EmailTakenValidatorImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(EmailTaken constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        return !userRepository.existsByEmail(value);
    }
}
