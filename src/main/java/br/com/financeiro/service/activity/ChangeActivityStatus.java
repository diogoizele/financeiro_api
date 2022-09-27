package br.com.financeiro.service.activity;

import br.com.financeiro.controller.request.activity.ChangeActivityStatusRequest;
import br.com.financeiro.controller.response.activity.BasicActivityResponse;
import br.com.financeiro.model.Activity;
import br.com.financeiro.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.financeiro.mapper.activity.UpdateActivityMapper.toResponse;

@Service
public class ChangeActivityStatus {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private SearchActivityService searchActivityService;

    public BasicActivityResponse changeStatus(Long id, ChangeActivityStatusRequest request) {

        Activity activity = searchActivityService.searchById(id);

        activity.setStatus(request.getStatus());

        activityRepository.save(activity);

        return toResponse(activity);
    }
}
