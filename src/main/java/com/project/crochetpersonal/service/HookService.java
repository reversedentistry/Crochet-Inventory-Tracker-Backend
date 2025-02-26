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

    public Hook addNewHook(Hook hook) {
        return hookRepo.save(hook);
    }

    public Hook editHook(int hookId, Hook hook) {
        if (hookRepo.findById(hookId).isPresent()) {
            hook.setHookId(hookId);
            return hookRepo.save(hook);
        }

        return null;
    }

    public long totalHookCount() {
        return hookRepo.count();
    }

    public double totalSpent() {
        List<Hook> allHooks = hookRepo.findAll();
        double total = 0;

        for (Hook hook : allHooks) {
            total += hook.getCost();
        }

        return total;
    }

    public List<Hook> findAllHooks() {
        return hookRepo.findAll();
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
