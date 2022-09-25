package br.com.financeiro.controller;

import br.com.financeiro.controller.request.activity.CreateActivityRequest;
import br.com.financeiro.controller.request.activity.UpdateActivityRequest;
import br.com.financeiro.controller.response.activity.BasicActivityResponse;
import br.com.financeiro.controller.response.activity.GetActivityResponse;
import br.com.financeiro.model.Category;
import br.com.financeiro.service.activity.CreateActivityService;
import br.com.financeiro.service.activity.DeleteActivityService;
import br.com.financeiro.service.activity.GetActivitiesService;
import br.com.financeiro.service.activity.UpdateActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private GetActivitiesService getActivitiesService;

    @Autowired
    private CreateActivityService createActivityService;

    @Autowired
    private UpdateActivityService updateActivityService;

    @Autowired
    private DeleteActivityService deleteActivityService;

    @GetMapping
    public Page<GetActivityResponse> getActivities(@PathParam("category") Category category, Pageable pageable) {
        return getActivitiesService.getActivitiesByCategory(category, pageable);
    }

    @PostMapping
    public BasicActivityResponse createActivity(@Valid @RequestBody CreateActivityRequest request) {
        return createActivityService.create(request);
    }

    @PutMapping("/{id}")
    public BasicActivityResponse updateActivity(@PathVariable Long id, @Valid @RequestBody UpdateActivityRequest request) {
        return updateActivityService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable Long id) {
        deleteActivityService.delete(id);
    }
}
