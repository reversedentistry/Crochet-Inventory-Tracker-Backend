package com.project.crochetpersonal.controller;

import com.project.crochetpersonal.model.Hook;
import com.project.crochetpersonal.service.HookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/hooks")
@RestController
public class HookController {
    @Autowired
    HookService hookService;

    @PostMapping
    public Hook addHook(@RequestBody Hook newHook) {
        return hookService.addNewHook(newHook);
    }

    @PutMapping("/{hookId}")
    public ResponseEntity<Hook> editHook(@RequestBody Hook hook, @PathVariable int hookId) {
        return hookService.editHook(hookId, hook) != null
                ? ResponseEntity.status(200).body(hook)
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/{hookId}")
    public ResponseEntity<String> deleteHook(@PathVariable int hookId) {
        return hookService.deleteHook(hookId)
                ? ResponseEntity.status(200).body("Hook successfully deleted")
                : ResponseEntity.status(400).body("Error in deletion");
    }

    @GetMapping("/all")
    public List<Hook> getAllHooks() {
        return hookService.findAllHooks();
    }

    @GetMapping("/totalcost")
    public double getTotalHookCost() {
        return hookService.totalSpent();
    }

    @GetMapping("/total")
    public long getTotalNumberOfHooks() {
        return hookService.totalHookCount();
    }

    @GetMapping("/size/{size}")
    public List<Hook> getAllBySize(@PathVariable double size) {
        return hookService.findAllHooksBySize(size);
    }

    @GetMapping("/material/{material}")
    public List<Hook> getAllByMaterial(@PathVariable String material) {
        return hookService.findAllHooksByMaterial(material);
    }

    @GetMapping("/style/{style}")
    public List<Hook> getAllByStyle(@PathVariable String style) {
        return hookService.findAllHooksByStyle(style);
    }

    @GetMapping("/isTunisian")
    public List<Hook> getAllTunisian() {
        return hookService.findAllTunisian();
    }
}
