package com.sgt.user.service.external.services;

import com.sgt.user.service.entities.Anime;
import com.sgt.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingServiceExternalClient {

    @GetMapping("/ratings/{ratingId}")
    Anime getRating(@PathVariable("ratingId") String ratingId);

    @GetMapping("/ratings/users/{userId}")
    List<Rating> getRatingsByUserId(@PathVariable("userId") String userId);

    @GetMapping("/ratings")
    ResponseEntity<List<Rating>> getAllRatings();


}

