package com.sgt.user.service.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Anime {

    String id;
    String name;
    String description;
    String releaseDetails;
    String streamLink;
}
