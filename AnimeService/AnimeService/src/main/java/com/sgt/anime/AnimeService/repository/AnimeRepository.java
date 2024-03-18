package com.sgt.anime.AnimeService.repository;

import com.sgt.anime.AnimeService.entities.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, String> {
}
