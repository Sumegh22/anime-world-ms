package com.sgt.anime.AnimeService.service.impl;

import com.sgt.anime.AnimeService.entities.Anime;
import com.sgt.anime.AnimeService.repository.AnimeRepository;
import com.sgt.anime.AnimeService.service.AnimeService;
import com.sgt.anime.AnimeService.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AnimeServiceImpl implements AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    @Override
    public Anime createAnime(Anime anime) {
        String animeId = UUID.randomUUID().toString();
        anime.setId(animeId);
        return animeRepository.save(anime);
    }

    @Override
    public List<Anime> getAllAnimes() {
        return animeRepository.findAll();
    }

    @Override
    public Anime getAnimeById(String animeId) {
        return animeRepository.findById(animeId).orElseThrow(() -> new ResourceNotFoundException("Anime with given id does not exists !..  "+animeId));
    }

    @Override
    public void deleteAnimeById(String animeId) {
        animeRepository.deleteById(animeId);
    }
}
