package com.application.pidev.BankAccountsSettings.Utils.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BankAccountExistsValidatorImpl.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BankAccountExists {
    String message() default "{BankAccountNotExists}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
