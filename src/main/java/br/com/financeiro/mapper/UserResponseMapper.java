package br.com.financeiro.mapper;

import br.com.financeiro.controller.response.UserResponse;
import br.com.financeiro.model.User;

public class UserResponseMapper {

    public static UserResponse toResponse(User entity) {
        return UserResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .wage(entity.getWage())
                .build();
    }
}
