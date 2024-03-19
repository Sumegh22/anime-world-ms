package com.sgt.rating.RatingService.entities;

import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("anime_ratings")
public class Rating {

    @Id
    private String ratingId;
    private String userId;
    private String animeId;
    private Integer ratedStars;
    private String comments;

}
