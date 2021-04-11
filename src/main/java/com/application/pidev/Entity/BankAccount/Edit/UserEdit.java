package com.application.pidev.Entity.Edit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEdit {
    private Long id;
    private String identifier;
    private String email;

    
}
