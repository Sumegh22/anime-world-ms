package com.sgt.rating.RatingService;

import com.sgt.rating.RatingService.entities.Rating;
import com.sgt.rating.RatingService.service.RatingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;


@DataMongoTest
class RatingServiceApplicationTests {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	RatingService ratingService;


//	@Test
//	void createRating(){
//		mongoTemplate.createCollection("ratings_test");
//		Rating rating = Rating.builder().ratingId("test-rating").animeId("xyz").userId("abc").comments("bla bla bla").build();
////		mongoTemplate.getCollection("ratings_test").insertOne(rating);
//		ratingService.createRating(rating);
//		mongoTemplate.save(rating);
//		Assertions.assertEquals(mongoTemplate.getCollection("ratings_test").countDocuments(), 1);
//
//	}


}
