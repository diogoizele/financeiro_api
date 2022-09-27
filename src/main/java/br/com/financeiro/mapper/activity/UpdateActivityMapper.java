package br.com.financeiro.mapper.activity;

import br.com.financeiro.controller.response.activity.BasicActivityResponse;
import br.com.financeiro.model.Activity;

public class UpdateActivityMapper {
    public static BasicActivityResponse toResponse(Activity entity) {

        return BasicActivityResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .date(entity.getDate())
                .amount(entity.getAmount())
                .status(entity.getStatus())
                .build();
    }
}
