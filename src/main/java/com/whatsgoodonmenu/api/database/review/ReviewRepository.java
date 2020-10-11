package com.whatsgoodonmenu.api.database.review;

import com.whatsgoodonmenu.api.data.Review;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String>{
    
}
