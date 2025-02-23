package com.project.crochetpersonal.repository;

import com.project.crochetpersonal.model.Yarn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YarnRepository extends JpaRepository<Yarn, Integer> {
    List<Yarn> findAllByColor(String color);
    List<Yarn> findAllByColorAndUsedUpFalse(String color);
    List<Yarn> findAllByMaterial(String material);
    List<Yarn> findAllByUsedUpFalse();
    int countByColor(String color);
}
