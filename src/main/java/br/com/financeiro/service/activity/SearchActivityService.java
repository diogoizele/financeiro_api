package br.com.financeiro.service.activity;

import br.com.financeiro.model.Activity;
import br.com.financeiro.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class SearchActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public Activity searchById(Long id) {
        return activityRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Activity not found"));
    }
}
