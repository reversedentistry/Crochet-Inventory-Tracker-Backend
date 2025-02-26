package com.project.crochetpersonal.service;

import com.project.crochetpersonal.model.Hook;
import com.project.crochetpersonal.repository.HookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HookService {
    @Autowired
    HookRepository hookRepo;

    public long totalHookCount() {
        return hookRepo.count();
    }

    public List<Hook> findAllHooksBySize(double size) {
        return hookRepo.findAllBySize(size);
    }

    public List<Hook> findAllHooksByMaterial(String material) {
        return hookRepo.findAllByMaterial(material);
    }

    public List<Hook> findAllHooksByStyle(String style) {
        return hookRepo.findAllByStyle(style);
    }

    public List<Hook> findAllTunisian() {
        return hookRepo.findAllByIsTunisianTrue();
    }
}
