package br.com.financeiro.controller.response.activity;

import br.com.financeiro.model.Category;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder @NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class GetActivityResponse {

        private Long id;
        private String title;
        private LocalDateTime date;
        private Category category;
        private BigDecimal amount;
        private String description;
}
