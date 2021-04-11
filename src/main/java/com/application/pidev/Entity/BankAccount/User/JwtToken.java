package com.application.pidev.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Immutable;

@Getter
@Immutable
@AllArgsConstructor
public class JwtToken {
    private String token;

    private JwtToken(){}
}
