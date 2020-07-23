package com.whatsgoodonmenu.api.controllers;

import com.whatsgoodonmenu.api.data.User;
import com.whatsgoodonmenu.api.response.UserResponse;
import com.whatsgoodonmenu.api.services.user.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
@RestController
public class UserController {

    @Autowired UsersService usersService;

    @PostMapping("/users")
    @CrossOrigin(origins = "*")
    public ResponseEntity<UserResponse> saveToDatabase(@RequestBody final User user) {
        String returnedMessage = "";
        final User createdAccount = usersService.createAccount(user);
        if (createdAccount == null) {
            returnedMessage = "The email address you entered has already been registered.";
        } else {
            returnedMessage = "Account has been created";
        }
        log.info("account creation status -> " + returnedMessage);
        final UserResponse userResponse = new UserResponse();
        userResponse.setMessage(returnedMessage);
        if(createdAccount == null){
            //email id already exists - 409 code
            return ResponseEntity.status(HttpStatus.CONFLICT).body(userResponse);
        } else {
            //status ok - 200 code
            return ResponseEntity.ok().body(userResponse);
        }
    } 
}