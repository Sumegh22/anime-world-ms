package com.sgt.rating.RatingService.repository;

import com.sgt.rating.RatingService.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RatingRepostory extends MongoRepository<Rating, String> {

}
