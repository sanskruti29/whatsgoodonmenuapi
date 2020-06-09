package com.whatsgoodonmenu.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountController {
    @GetMapping("/count")
    @CrossOrigin(origins = "*")
    public int count(){
        return 1;
    }
}