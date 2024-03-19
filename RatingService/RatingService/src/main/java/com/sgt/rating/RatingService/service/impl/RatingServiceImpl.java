package com.sgt.rating.RatingService.service.impl;

import com.sgt.rating.RatingService.entities.Rating;
import com.sgt.rating.RatingService.repository.RatingRepostory;
import com.sgt.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepostory repostory;

    @Override
    public Rating createRating(Rating rating) {
        String ratingId = UUID.randomUUID().toString();
        rating.setRatingId(ratingId);
        return repostory.save(rating);
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
