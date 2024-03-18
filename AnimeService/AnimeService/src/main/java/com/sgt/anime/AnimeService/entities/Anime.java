package com.sgt.anime.AnimeService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Entity
@Table(name="anime")
@Getter
@Service
@NoArgsConstructor
@AllArgsConstructor
public class Anime {

    @Id
    String idd;
    String name;
    String description;
    String releaseDetails;
    String desription;
}
