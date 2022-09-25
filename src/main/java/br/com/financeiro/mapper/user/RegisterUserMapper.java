package br.com.financeiro.mapper.user;

import br.com.financeiro.controller.request.user.RegisterUserRequest;
import br.com.financeiro.controller.response.UserResponse;
import br.com.financeiro.model.User;

public class RegisterUserMapper {

    public static User toEntity(RegisterUserRequest request) {
        return User.builder()
                .name(request.getName())
                .wage(request.getWage())
                .build();
    }

    public static UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .wage(user.getWage())
                .build();
    }
}
