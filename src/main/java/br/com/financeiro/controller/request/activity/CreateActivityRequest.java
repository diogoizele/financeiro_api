package br.com.financeiro.controller.request.activity;

import br.com.financeiro.model.Category;
import lombok.*;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;

@Builder @NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CreateActivityRequest {

    @NotBlank
    private String title;

    @NotNull
    private LocalDateTime date;

    @NotNull
    @Enumerated(STRING)
    private Category category;

    @NotNull
    private BigDecimal amount;

    private String description;
}
