package com.whatsgoodonmenu.api.database.login;

import com.whatsgoodonmenu.api.data.Login;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoginRepository extends MongoRepository<Login, String>{
    
}