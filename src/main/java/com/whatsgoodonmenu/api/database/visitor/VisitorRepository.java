package com.whatsgoodonmenu.api.database.visitor;

import com.whatsgoodonmenu.api.data.Visitor;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VisitorRepository extends MongoRepository<Visitor, String>{
    
}