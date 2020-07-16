package com.whatsgoodonmenu.api.services.login;

import com.whatsgoodonmenu.api.data.Login;
import com.whatsgoodonmenu.api.database.login.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class LoginService {
    @Autowired LoginRepository loginRepository;
    
    public Login userLogin(Login login){
        String email = login.getEmail();
       
        Login returnedLogin = loginRepository.save(login);
        log.info("Your emailID is: " + email);
        return returnedLogin;
    }
}