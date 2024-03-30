package com.sgt.user.service.external.services;

import com.sgt.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingServiceExternalClient {

    @PutMapping("/ratings/{ratingId}")
    Rating updateRating(@PathVariable("ratingId") String ratingId, Rating newValues);

    @DeleteMapping("/ratings/{ratingId}")
    void deleteRating(@PathVariable("ratingId") String ratingId);

    @GetMapping("/ratings/users/{userId}")
    List<Rating> getRatingsByUserId(@PathVariable("userId") String userId);

    @GetMapping("/ratings")
    List<Rating> getAllRatings();


}

