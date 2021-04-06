package com.application.pidev.BankAccountsSettings.Utils.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PostCodeValidatorImpl.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PostCode {
    String message() default "{PostCode}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
