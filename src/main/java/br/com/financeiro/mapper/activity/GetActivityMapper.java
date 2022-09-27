package br.com.financeiro.mapper.activity;

import br.com.financeiro.controller.response.activity.GetActivityResponse;
import br.com.financeiro.model.Activity;

public class GetActivityMapper {
    public static GetActivityResponse toResponse(Activity entity) {
        return GetActivityResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .amount(entity.getAmount())
                .category(entity.getCategory())
                .date(entity.getDate())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .build();
    }
}
