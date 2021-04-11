package com.application.pidev.Entity.Edit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountEdit {

    @Length(min = 26, max = 26)
    private String number;

}