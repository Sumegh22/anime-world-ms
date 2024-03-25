package com.sgt.user.service.service.impl;

import com.sgt.user.service.entities.Anime;
import com.sgt.user.service.entities.Rating;
import com.sgt.user.service.entities.User;
import com.sgt.user.service.exceptions.ResourceNotFoundException;
import com.sgt.user.service.repositories.UserRepository;
import com.sgt.user.service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserID = UUID.randomUUID().toString();
        user.setUserId(randomUserID);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String userId) {
    User newUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id could not be found !..  : "+userId));
    Rating[] ratingsByThisUser =  restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+userId, Rating[].class);
    List<Rating> ratings = Arrays.asList(ratingsByThisUser);

    List<Rating> allRatingsByUser = ratings.stream().map(rating -> {
     ResponseEntity<Anime> animeResponseEntity =  restTemplate.getForEntity("http://ANIME-SERVICE/anime/"+rating.getAnimeId(), Anime.class);
     Anime anime = animeResponseEntity.getBody();
     rating.setAnime(anime);
     return rating;
    }).collect(Collectors.toList()) ;

    LOGGER.info("Ratings given by user {},  are as: {}",newUser.getName(), ratingsByThisUser);
    newUser.setRatings(allRatingsByUser);
    return newUser;
    }

    @Override
    public boolean deleteUser(String userId) {
        return false;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
