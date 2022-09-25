package br.com.financeiro.service.user;

import br.com.financeiro.controller.request.user.RegisterUserRequest;
import br.com.financeiro.controller.response.UserResponse;
import br.com.financeiro.mapper.user.RegisterUserMapper;
import br.com.financeiro.model.User;
import br.com.financeiro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static br.com.financeiro.mapper.user.RegisterUserMapper.toEntity;

@Service
public class RegisterUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserResponse register(RegisterUserRequest request) {

        User user = toEntity(request);
        user.setPassword(getEncryptedPassword(request.getPassword()));

        userRepository.save(user);

        return RegisterUserMapper.toResponse(user);
    }

    public String getEncryptedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
