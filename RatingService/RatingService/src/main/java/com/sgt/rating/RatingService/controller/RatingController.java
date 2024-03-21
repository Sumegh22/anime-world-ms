package com.sgt.rating.RatingService.controller;


import com.sgt.rating.RatingService.entities.Rating;
import com.sgt.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

@Autowired
private RatingService ratingService;

@PostMapping
public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
    return ResponseEntity.ok(ratingService.createRating(rating));
}

@GetMapping
public ResponseEntity<List<Rating>> getAllRatings(){
    return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatings());
}

@GetMapping("/users/{userId}")
public ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable String userId){
    return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingsByUserId(userId));
}

@GetMapping("/anime/{animeId}")
public ResponseEntity<List<Rating>> getAllRatingsByAnimeId(@PathVariable String animeId){
    return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingsByAnimeId(animeId));
}

}
