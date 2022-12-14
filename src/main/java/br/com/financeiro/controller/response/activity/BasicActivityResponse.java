package br.com.financeiro.controller.response.activity;

import br.com.financeiro.model.ActivityStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder @NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class BasicActivityResponse {

    private Long id;
    private String title;
    private LocalDateTime date;
    private BigDecimal amount;
    private ActivityStatus status;
}
