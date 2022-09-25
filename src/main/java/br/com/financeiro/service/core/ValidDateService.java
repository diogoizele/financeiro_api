package br.com.financeiro.service.core;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidDateService {

    public void validDate(LocalDateTime date) {

        if (date.isAfter(LocalDateTime.now())) {
            throw new ResponseStatusException(BAD_REQUEST, "Date must be greater than or equal to the current date");
        }
    }
}
