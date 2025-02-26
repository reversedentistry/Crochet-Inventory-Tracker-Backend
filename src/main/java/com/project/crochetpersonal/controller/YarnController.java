package com.project.crochetpersonal.controller;

import com.project.crochetpersonal.model.Yarn;
import com.project.crochetpersonal.service.YarnService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class YarnController {
    @Autowired
    YarnService yarnService;

    @PostMapping
    public Yarn addYarn(@RequestBody Yarn yarn) {
        return yarnService.addNewYarn(yarn);
    }

    @GetMapping("/yarn/unused")
    public List<Yarn> getAllUnfinishedYarn() {
        return yarnService.findAllYarnNotUsedUp();
    }

    @GetMapping("/yarn/all")
    public List<Yarn> getAllYarn() {
        return yarnService.findAll();
    }

    @GetMapping("/yarn/total")
    public double getTotalSpent() {
        return yarnService.totalSpent();
    }

    @GetMapping("/yarn/unused/{color}")
    public List<Yarn> getAllUnusedByColor(@PathVariable String color) {
        return yarnService.findAllByColor(color);
    }

    @GetMapping("/yarn/unused/{material}")
    public List<Yarn> getAllUnusedByMaterial(@PathVariable String material) {
        return yarnService.findAllByMaterial(material);
    }

    @PutMapping("/{yarnId}")
    public ResponseEntity<Yarn> editYarn(@RequestBody Yarn yarn, @PathVariable int yarnId) {
        return yarnService.editYarn(yarnId, yarn) != null
                ? ResponseEntity.status(200).body(yarn)
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/{yarnId}")
    public ResponseEntity<String> deleteYarn(@PathVariable int id) {
        return yarnService.deleteYarn(id)
                ? ResponseEntity.status(200).body("Successfully deleted")
                : ResponseEntity.status(400).body("There was an issue with deletion");
    }
}
