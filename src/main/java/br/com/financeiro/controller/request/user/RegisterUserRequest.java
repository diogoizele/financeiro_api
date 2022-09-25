package br.com.financeiro.controller.request.user;

import lombok.*;

import java.math.BigDecimal;

@Builder @NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class RegisterUserRequest {

    private String name;
    private String password;
    private BigDecimal wage;
}
