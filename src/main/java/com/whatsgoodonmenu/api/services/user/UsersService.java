package com.whatsgoodonmenu.api.services.user;

import com.whatsgoodonmenu.api.data.User;
import com.whatsgoodonmenu.api.database.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class UsersService {
    
    @Autowired UserRepository userRepository;

    public User createAccount(User user) {
        // String firstName = user.getFirstName();
        // String lastName = user.getLastName();
        String email = user.getEmail();
        User returnedUser = null;
        if(!userRepository.existsById(email)){
            returnedUser = userRepository.save(user);
            log.info("Saving in database");
        } else {
            log.info("This email id is already taken!");
        }
        // log.info("Creating account for:  " + firstName + " " + lastName);
		return returnedUser;
	}
}