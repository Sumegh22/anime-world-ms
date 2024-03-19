package com.sgt.anime.AnimeService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Entity
@Table(name="anime")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Anime {

    @Id
    String id;
    String name;
    String description;
    String releaseDetails;
    String streamLink;
}
