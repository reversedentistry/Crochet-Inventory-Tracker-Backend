package com.project.crochetpersonal.controller;

import com.project.crochetpersonal.service.HookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HookController {
    @Autowired
    HookService hookService;
}
