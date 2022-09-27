package br.com.financeiro.mapper.activity;

import br.com.financeiro.controller.request.activity.CreateActivityRequest;
import br.com.financeiro.controller.response.activity.BasicActivityResponse;
import br.com.financeiro.model.Activity;

public class CreateActivityMapper {

    public static Activity toEntity(CreateActivityRequest request) {
        return Activity.builder()
                .title(request.getTitle())
                .date(request.getDate())
                .amount(request.getAmount())
                .category(request.getCategory())
                .description(request.getDescription())
                .build();
    }

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
