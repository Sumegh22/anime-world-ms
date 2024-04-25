package com.sgt.user.service.controllers;

import com.sgt.user.service.entities.Rating;
import com.sgt.user.service.entities.User;
import com.sgt.user.service.service.UserService;
import com.sgt.user.service.service.impl.UserServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    Logger LOGGER = LoggerFactory.getLogger(UserController.class);


    //create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    // get Single user
    @GetMapping("/{userId}")
    @CircuitBreaker(name="userRatingBreaker", fallbackMethod = "sendDummyAnimeRatingsForUser")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
        User requestedUser = userService.getUserById(userId);
        return ResponseEntity.ok(requestedUser);
    }
    // get All user
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUserList = userService.getAllUsers();
        return ResponseEntity.ok(allUserList);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User newUser, @PathVariable String userId){
        User updatedUser = userService.updateUser(userId, newUser);
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/{userId}")
    boolean deleteUserById(@PathVariable String userId){
        return userService.deleteUserById(userId);
    }

    public ResponseEntity<User> sendDummyAnimeRatingsForUser(String userId, Exception ex){
        LOGGER.warn("Fallback is getting executed as the service is down: {}", ex);
        List<Rating> dummyRatings = new ArrayList<>();
//        userService.getUserById(userId);
        dummyRatings.add(new Rating("DummyRating",userId, "DummyAnimeId", null, 0,"This is a dummy rating, which is loaded because service is down"));
        User dummyUser =  User.builder().userId(userId).name("DummyName").email("test@email.com").ratings(dummyRatings).build();
        return ResponseEntity.ok(dummyUser);
    }

    public ResponseEntity<List<User>> sendDummyAnimeRatingsForAllUsers(String userId, Exception ex){
        LOGGER.warn("Fallback is getting executed as the service is down: {}", ex);
        List<User> allUsers = userService.getAllUsers();
        List<Rating> dummyRatings = new ArrayList<>();
        dummyRatings.add(new Rating("DummyRating",userId, "DummyAnimeId", null, 0,"This is a dummy rating, which is loaded because service is down"));
        List<User> tempUserlist = List.copyOf(allUsers);
        tempUserlist.stream().forEach( u -> u.setRatings(dummyRatings));
        return ResponseEntity.ok(tempUserlist);
    }


}
