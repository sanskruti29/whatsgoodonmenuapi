package com.whatsgoodonmenu.api.controllers;

import com.whatsgoodonmenu.api.data.Login;
import com.whatsgoodonmenu.api.response.LoginResponse;
import com.whatsgoodonmenu.api.services.login.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired LoginService loginService;
    @PostMapping("/login")
    @CrossOrigin(origins = "*")
   
    public ResponseEntity<LoginResponse> login(@RequestBody Login login) {
        String returnedMessage = "";
        final boolean accountLogin = loginService.userLogin(login);
        if (accountLogin == true) {
            returnedMessage = "Welcome!";
        } else {
            returnedMessage = "The email ID or password you entered is incorrect";
        }
        final LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage(returnedMessage);
        
        return ResponseEntity.status( accountLogin ? HttpStatus.OK : HttpStatus.UNAUTHORIZED)
                            .body(loginResponse);
    }  
}