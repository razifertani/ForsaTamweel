package com.application.pidev.Entity.In;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import com.application.pidev.BankAccountsSettings.Utils.validators.EmailTaken;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserIn {

    @Length(min = 8, max = 100)
    @NotNull
    private String password;

    private String confirmPassword;

    @EmailTaken
    private String email;

}
