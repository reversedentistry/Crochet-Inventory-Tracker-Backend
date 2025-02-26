package com.project.crochetpersonal.controller;

import com.project.crochetpersonal.model.Yarn;
import com.project.crochetpersonal.service.YarnService;
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
        yarnService.addNewYarn(yarn);
        return yarn;
    }

    @GetMapping
    public List<Yarn> getAllUnfinishedYarn() {
        return yarnService.findAllYarnNotUsedUp();
    }

    @GetMapping
    public List<Yarn> getAllYarn() {
        return yarnService.findAll();
    }

    @PutMapping("/{yarnId}")
    public ResponseEntity<Yarn> editYarn(@RequestBody Yarn yarn, @PathVariable int yarnId) {
        return yarnService.editYarn(yarnId, yarn) != null
                ? ResponseEntity.status(200).body(yarn)
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
