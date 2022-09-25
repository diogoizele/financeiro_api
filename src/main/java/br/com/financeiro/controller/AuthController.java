package br.com.financeiro.controller;

import br.com.financeiro.controller.request.user.RegisterUserRequest;
import br.com.financeiro.controller.response.UserResponse;
import br.com.financeiro.service.user.RegisterUserService;
import br.com.financeiro.service.user.UserAuthenticatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserAuthenticatedService userAuthenticatedService;

    @Autowired
    private RegisterUserService registerUserService;

    @PostMapping("/login")
    public UserResponse auth() {
        return userAuthenticatedService.getReponse();
    }

    @PostMapping("/register")
    public UserResponse register(@Valid  @RequestBody RegisterUserRequest request) {
        return registerUserService.register(request);
    }
}
