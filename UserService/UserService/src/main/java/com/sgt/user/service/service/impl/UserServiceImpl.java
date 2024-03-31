package com.sgt.user.service.service.impl;

import com.sgt.user.service.entities.Anime;
import com.sgt.user.service.entities.Rating;
import com.sgt.user.service.entities.User;
import com.sgt.user.service.exceptions.ResourceNotFoundException;
import com.sgt.user.service.external.services.AnimeServiceExternalClient;
import com.sgt.user.service.external.services.RatingServiceExternalClient;
import com.sgt.user.service.repositories.UserRepository;
import com.sgt.user.service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    private AnimeServiceExternalClient animeServiceFeignClient;
    @Autowired
    RatingServiceExternalClient ratingServiceExternalClient;
    Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserID = UUID.randomUUID().toString();
        user.setUserId(randomUserID);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        allUsers.stream().forEach(user -> {
            user.setRatings(getRatingsByUserId(user.getUserId()));
        });
        return allUsers;
    }

    @Override
    public User getUserById(String userId) {
    User newUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id could not be found !..  : "+userId));
    List<Rating> allRatingsByUser = getRatingsByUserId(userId);
    LOGGER.info("Ratings given by user {},  are as: {}",newUser.getName(), allRatingsByUser);
    newUser.setRatings(allRatingsByUser);
    return newUser;
    }

    @Override
    public boolean deleteUser(String userId) {
        return false;
    }

    @Override
    public User updateUser(String userId, User updatedUser) {
       User fetchedUser =  userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("No user found for the given userId"+userId));
       fetchedUser.setName(updatedUser.getName());
       fetchedUser.setEmail(updatedUser.getEmail());
       fetchedUser.setAbout(updatedUser.getAbout());
       fetchedUser.setRatings(updatedUser.getRatings());
       userRepository.save(fetchedUser);
       return fetchedUser;
    }

    @Override
    public ResponseEntity<User> userRatingFallBackMethod (String userId, Exception e){
        LOGGER.warn("Exception occurred while trying to load ratings {} ",e.getMessage());
        LOGGER.warn("Could not load ratings for this user {}, check your rating service health !.. Fall back method called", userId);
        User thisUser =  getUserById(userId);
        List<Rating> dummyRating = new ArrayList<>();
        dummyRating.add(Rating.builder().ratingId("dummyRatingId").ratedStars(0).comments("returned Dummy rating due because rating could not be fetched for: "+userId).build());
        thisUser.setRatings(dummyRating);
        return ResponseEntity.ok().body(thisUser);
    }

    public List<Rating> getRatingsByUserId(String userId){
        List<Rating> ratings = ratingServiceExternalClient.getRatingsByUserId(userId);
        List<Rating> allRatingsByUser = ratings.stream().map(rating -> {
            Anime anime = animeServiceFeignClient.getAnime(rating.getAnimeId());
            rating.setAnime(anime);
            return rating;
        }).collect(Collectors.toList()) ;
        return allRatingsByUser;
    }

//    public List<Rating> getRatingsByUserId(String userId){
//        Rating[] ratingsByThisUser =  restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+userId, Rating[].class);
//        List<Rating> ratings = Arrays.asList(ratingsByThisUser);
//        List<Rating> allRatingsByUser = ratings.stream().map(rating -> {
//          ResponseEntity<Anime> animeResponseEntity =  restTemplate.getForEntity("http://ANIME-SERVICE/anime/"+rating.getAnimeId(), Anime.class);
//          Anime anime = animeResponseEntity.getBody();
//          rating.setAnime(anime);
//          return rating;
//        }).collect(Collectors.toList()) ;
//        return allRatingsByUser;
//    }

}
