package br.com.financeiro.repository;

import br.com.financeiro.model.Activity;
import br.com.financeiro.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    Page<Activity> findAllByUserIdAndCategory(Long userId, Category category, Pageable pageable);

    Page<Activity> findAllByUserId(Long userId, Pageable pageable);
}
