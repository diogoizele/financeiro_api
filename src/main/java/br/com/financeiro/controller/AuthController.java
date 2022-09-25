package br.com.financeiro.controller;

import br.com.financeiro.controller.response.UserResponse;
import br.com.financeiro.service.user.UserAuthenticatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserAuthenticatedService userAuthenticatedService;

    @PostMapping("/login")
    public UserResponse auth() {
        return userAuthenticatedService.getReponse();
    }
}
