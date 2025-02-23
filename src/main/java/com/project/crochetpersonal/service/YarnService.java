package com.project.crochetpersonal.service;

import lombok.*;

import com.project.crochetpersonal.model.Yarn;
import com.project.crochetpersonal.repository.YarnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class YarnService {
    @Autowired
    YarnRepository yarnRepo;

    public Yarn addNewYarn(Yarn newYarn) {
        return yarnRepo.save(newYarn);
    }

    public Yarn editYarn(int id, Yarn yarn) {
        if (yarnRepo.findById(id).isPresent()) {
            yarn.setId(id);
            return yarnRepo.save(yarn);
        }
        return null;
    }

    public boolean deleteYarn(int id) {
        if (yarnRepo.findById(id).isPresent()) {
            yarnRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Yarn> findAll() {
        return yarnRepo.findAll();
    }

    public List<Yarn> findAllYarnNotUsedUp() {
        return yarnRepo.findAllByUsedUpFalse();
    }
}
