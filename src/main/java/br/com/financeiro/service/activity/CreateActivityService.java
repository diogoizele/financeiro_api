package br.com.financeiro.service.activity;

import br.com.financeiro.controller.request.activity.CreateActivityRequest;
import br.com.financeiro.controller.response.activity.BasicActivityResponse;
import br.com.financeiro.model.Activity;
import br.com.financeiro.model.User;
import br.com.financeiro.repository.ActivityRepository;
import br.com.financeiro.service.core.ValidDateService;
import br.com.financeiro.service.user.UserAuthenticatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.financeiro.mapper.activity.CreateActivityMapper.toEntity;
import static br.com.financeiro.mapper.activity.CreateActivityMapper.toResponse;

@Service
public class CreateActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private UserAuthenticatedService userAuthenticatedService;

    @Autowired
    private ValidDateService validDateService;

    @Transactional
    public BasicActivityResponse create(CreateActivityRequest request) {

        validDateService.validDate(request.getDate());

        User user = userAuthenticatedService.get();

        Activity activity = toEntity(request);
        activity.setUser(user);

        activityRepository.save(activity);

        return toResponse(activity);
    }
}
