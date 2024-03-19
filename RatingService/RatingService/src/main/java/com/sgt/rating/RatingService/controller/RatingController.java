package com.sgt.rating.RatingService.controller;


import com.sgt.rating.RatingService.entities.Rating;
import com.sgt.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingController {

@Autowired
private RatingService ratingService;

public ResponseEntity<Rating> getAllRatings(){


}

}
