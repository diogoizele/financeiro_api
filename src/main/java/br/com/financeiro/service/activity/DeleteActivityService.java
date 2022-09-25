package br.com.financeiro.service.activity;

import br.com.financeiro.model.Activity;
import br.com.financeiro.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private SearchActivityService searchActivityService;

    public void delete(Long id) {

        Activity activity = searchActivityService.searchById(id);

        activityRepository.delete(activity);
    }
}
