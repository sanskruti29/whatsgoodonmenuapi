package com.whatsgoodonmenu.api.data;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Review {
    @Id
    public String reviewId;
    public int starRating;
    public String restaurantName;
    public String review;
}
