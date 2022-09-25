package br.com.financeiro.service.user;

import br.com.financeiro.controller.response.UserResponse;
import br.com.financeiro.mapper.UserResponseMapper;
import br.com.financeiro.model.User;
import br.com.financeiro.repository.UserRepository;
import br.com.financeiro.security.config.UserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import static br.com.financeiro.mapper.UserResponseMapper.toResponse;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class UserAuthenticatedService {

    @Autowired
    private UserRepository userRepository;

    public Long getId() {

        Authentication authentication = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof UserSecurity) {
            return ((UserSecurity) authentication.getPrincipal()).getId();
        }

        return null;
    }

    public User get() {
        Long id = getId();

        if (isNull(id)) {
            return null;
        }

        return userRepository.findById(id).orElse(null);
    }

    public UserResponse getReponse() {

        User entity = get();
        return nonNull(entity) ? toResponse(entity) : new UserResponse();
    }
}
