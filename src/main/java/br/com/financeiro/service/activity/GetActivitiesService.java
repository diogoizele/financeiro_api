package br.com.financeiro.service.activity;

import br.com.financeiro.controller.response.activity.GetActivityResponse;
import br.com.financeiro.mapper.activity.GetActivityMapper;
import br.com.financeiro.model.Category;
import br.com.financeiro.repository.ActivityRepository;
import br.com.financeiro.service.user.UserAuthenticatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GetActivitiesService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private UserAuthenticatedService userAuthenticatedService;

    public Page<GetActivityResponse> getActivitiesByCategory(Category category, Pageable pageable) {
        Long userId = userAuthenticatedService.getId();

        return activityRepository.findAllByUserIdAndCategory(userId, category, pageable)
                .map(GetActivityMapper::toResponse);
    }
}
