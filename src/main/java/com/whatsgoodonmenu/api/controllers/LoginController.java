package com.whatsgoodonmenu.api.controllers;

import com.whatsgoodonmenu.api.data.Login;
import com.whatsgoodonmenu.api.services.login.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController
public class LoginController {

    @Autowired LoginService loginService;

    @PostMapping("/login")
    @CrossOrigin(origins = "*")
    public void saveToDatabase(@RequestBody Login login){
        log.info("processing");

        // Login loggedIn = loginService.userLogin(login);
    }
}