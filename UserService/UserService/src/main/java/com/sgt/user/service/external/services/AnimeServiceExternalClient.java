package com.sgt.user.service.external.services;

import com.sgt.user.service.entities.Anime;
import com.sgt.user.service.entities.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name = "ANIME-SERVICE")
public interface AnimeServiceExternalClient {

    @GetMapping("/anime/{animeId}")
    Anime getAnime(@PathVariable("animeId") String animeId);

    @GetMapping("/anime")
    ResponseEntity<List<Anime>> getAllAnimes();


}

