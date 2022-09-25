package br.com.financeiro.controller.response;

import lombok.*;

import java.math.BigDecimal;

@Builder @NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class UserResponse {

        private Long id;
        private String name;
        private BigDecimal wage;
}
