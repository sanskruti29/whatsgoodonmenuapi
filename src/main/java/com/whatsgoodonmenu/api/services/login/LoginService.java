package com.whatsgoodonmenu.api.services.login;

import com.whatsgoodonmenu.api.data.Login;
import com.whatsgoodonmenu.api.data.User;
import com.whatsgoodonmenu.api.database.login.LoginRepository;
import com.whatsgoodonmenu.api.database.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {

    @Autowired LoginRepository loginRepository;
    @Autowired UserRepository userRepository;

    public boolean userLogin(Login login){
        return userRepository.findById(login.getEmail())
                .map(user -> processUserPresent(user, login.getPassword()))
                .orElseGet(()-> false);
    }

    //if the email id already exists and the password equals database password then login
    public boolean processUserPresent(User user, String password){
        if(user.getPassword().equals(password)){
            return true;
        } else {
            return false;
        }
    }
}