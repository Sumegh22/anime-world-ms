package com.sgt.rating.RatingService.service;

import com.sgt.rating.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {
    //create
    Rating createRating(Rating rating);

    //getALlRatings

    List<Rating> getAllRatings();

    //getAllByUserId
    List<Rating> getRatingsByUserId(String userId);

    //getAllByAnimeId
    List<Rating> getRatingsByAnimeId(String animeId);

}
