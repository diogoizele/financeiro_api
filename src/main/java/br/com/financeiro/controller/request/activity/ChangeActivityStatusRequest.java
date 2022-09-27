package br.com.financeiro.controller.request.activity;

import br.com.financeiro.model.ActivityStatus;
import lombok.*;

import javax.validation.constraints.NotNull;

@Builder @NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ChangeActivityStatusRequest {
    @NotNull
    private ActivityStatus status;
}
