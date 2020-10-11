package com.whatsgoodonmenu.api.controllers;

import com.whatsgoodonmenu.api.data.Review;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController
public class ReviewController {
    @PostMapping("/reviews")
    public void review(@RequestBody Review review){
        log.info("review: " + review);
    }

    //getReviews

    //postReviews

    //editReviews

    //deleteReviews
}
