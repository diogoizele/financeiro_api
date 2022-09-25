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

    public static BasicActivityResponse toResponse(Activity activity) {
        return BasicActivityResponse.builder()
                .id(activity.getId())
                .title(activity.getTitle())
                .date(activity.getDate())
                .amount(activity.getAmount())
                .build();
    }
}
