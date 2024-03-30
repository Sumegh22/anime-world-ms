package com.sgt.rating.RatingService.service;

import com.sgt.rating.RatingService.entities.Rating;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public interface RatingService {
    //create
    Rating createRating(Rating rating);
    Rating updateRating(String ratingId, Rating newValues);
    boolean deleteRating(String ratingId);

    //getALlRatings
    List<Rating> getAllRatings();

    //getAllByUserId
    List<Rating> getRatingsByUserId(String userId);

    //getAllByAnimeId
    List<Rating> getRatingsByAnimeId(String animeId);

}
