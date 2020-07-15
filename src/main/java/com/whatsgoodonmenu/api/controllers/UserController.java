package com.whatsgoodonmenu.api.controllers;

import com.whatsgoodonmenu.api.data.User;
import com.whatsgoodonmenu.api.services.user.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired UsersService usersService;

    @PostMapping("/users")
    @CrossOrigin(origins = "*")
    public User saveToDatabase(@RequestBody User user){
        User createdAccount = usersService.createAccount(user);
        return createdAccount;
    }
}