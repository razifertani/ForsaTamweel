package com.application.pidev.Entity.Out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserOut {
    private Long ID;

    private String identifier;

    private String email;


    private boolean locked;
}
