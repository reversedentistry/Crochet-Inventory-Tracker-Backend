package com.project.crochetpersonal.repository;

import com.project.crochetpersonal.model.Hook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HookRepository extends JpaRepository<Hook, Integer> {
    List<Hook> findAllBySize(double size);
    List<Hook> findAllByStyle(String style);
    List<Hook> findAllByMaterial(String material);
    List<Hook> findAllByIsTunisianTrue();
}
