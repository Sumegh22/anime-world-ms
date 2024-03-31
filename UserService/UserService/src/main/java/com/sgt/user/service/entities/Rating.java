package com.sgt.user.service.entities;

import lombok.*;

import javax.annotation.processing.Generated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    private String ratingId;
    private String userId;
    private String animeId;
    private Anime anime;
    private Integer ratedStars;
    private String comments;

}
