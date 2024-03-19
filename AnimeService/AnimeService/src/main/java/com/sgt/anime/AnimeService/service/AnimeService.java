package com.sgt.anime.AnimeService.service;

import com.sgt.anime.AnimeService.entities.Anime;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AnimeService {

    Anime createAnime(Anime anime);

    List<Anime> getAllAnimes();

//    Anime updateAnime(Anime anime);

    Anime getAnimeById(String animeId);

    void deleteAnimeById(String animeId);

}
