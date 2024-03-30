package com.sgt.rating.RatingService.service.impl;

import com.sgt.rating.RatingService.entities.Rating;
import com.sgt.rating.RatingService.repository.RatingRepostory;
import com.sgt.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepostory repostory;

    @Override
    public Rating createRating(Rating rating) {
        Rating rating1 = rating;
        rating.setRatingId(UUID.randomUUID().toString());
        return repostory.save(rating);
    }

    @Override
    public Rating updateRating(String ratingId, Rating newValues) {
        Rating ratingToUpdate = repostory.findById(ratingId).get();
        ratingToUpdate.setComments(newValues.getComments());
        ratingToUpdate.setRatedStars(newValues.getRatedStars());
        repostory.save(ratingToUpdate);
        return ratingToUpdate;
    }
    @Override
    public boolean deleteRating(String ratingId) {
        if(!(repostory.findById(ratingId).isEmpty()) ){
            return false;
        }
        repostory.deleteById(ratingId);
        return true;
    }

    @Override
    public List<Rating> getAllRatings() {
        return repostory.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return repostory.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByAnimeId(String animeId) {
        return repostory.findByAnimeId(animeId);
    }
}
