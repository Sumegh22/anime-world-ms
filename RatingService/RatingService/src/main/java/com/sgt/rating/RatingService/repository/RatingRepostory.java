package com.sgt.rating.RatingService.repository;

import com.sgt.rating.RatingService.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepostory extends MongoRepository<Rating, String> {

    List<Rating> findByUserId(String userId);

    List<Rating> findByAnimeId(String animeId);

    void deleteById(String ratingId);
}
