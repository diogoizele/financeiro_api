package br.com.financeiro.service.activity;

import br.com.financeiro.controller.request.activity.UpdateActivityRequest;
import br.com.financeiro.controller.response.activity.BasicActivityResponse;
import br.com.financeiro.model.Activity;
import br.com.financeiro.repository.ActivityRepository;
import br.com.financeiro.service.core.ValidDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.financeiro.mapper.activity.UpdateActivityMapper.toResponse;

@Service
public class UpdateActivityService {

    @Autowired
    private SearchActivityService searchActivityService;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ValidDateService validDateService;

    public BasicActivityResponse update(Long id, UpdateActivityRequest request) {

        validDateService.validDate(request.getDate());

        Activity activity = searchActivityService.searchById(id);

        activity.setTitle(request.getTitle());
        activity.setDate(request.getDate());
        activity.setAmount(request.getAmount());
        activity.setCategory(request.getCategory());
        activity.setDescription(request.getDescription());

        activityRepository.save(activity);

        return toResponse(activity);
    }
}
