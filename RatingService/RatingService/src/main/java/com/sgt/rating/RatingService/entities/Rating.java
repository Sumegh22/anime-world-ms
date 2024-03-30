package com.sgt.rating.RatingService.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("anime_ratings")
public class Rating {

    @Id
    private String ratingId;
    private String userId;
    private String animeId;
    private Integer ratedStars;
    private String comments;

}
