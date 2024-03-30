package com.sgt.rating.RatingService.service;

import com.sgt.rating.RatingService.entities.Rating;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public interface RatingService {
    Rating createRating(Rating rating);
    Rating updateRating(String ratingId, Rating newValues);
    boolean deleteRating(String ratingId);
    List<Rating> getAllRatings();
    List<Rating> getRatingsByUserId(String userId);
    List<Rating> getRatingsByAnimeId(String animeId);

}
