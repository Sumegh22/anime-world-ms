package com.sgt.anime.AnimeService.controller;


import com.sgt.anime.AnimeService.entities.Anime;
import com.sgt.anime.AnimeService.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anime")
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    @PostMapping
    public ResponseEntity<Anime> createAnime(@RequestBody Anime newAnime){
        return ResponseEntity.status(HttpStatus.CREATED).body(animeService.createAnime(newAnime));
    }

    @GetMapping("/{animeId}")
    public ResponseEntity<Anime> getAnime(@PathVariable String animeId){
        return ResponseEntity.status(HttpStatus.OK).body(animeService.getAnimeById(animeId));
    }

    @GetMapping
    public ResponseEntity<List<Anime>> getAllAnimes(){
        return ResponseEntity.status(HttpStatus.OK).body(animeService.getAllAnimes());
    }

    @PutMapping("/{animeId}")
    public ResponseEntity<Anime> updateAnime(@PathVariable String animeId, @RequestBody Anime updatedBody){
        return ResponseEntity.status(HttpStatus.OK).body(animeService.updateAnime(animeId, updatedBody));
    }

    @DeleteMapping("/{animeId}")
    public ResponseEntity<Boolean> deleteAnime(@PathVariable String animeId){
        animeService.deleteAnimeById(animeId);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

}
