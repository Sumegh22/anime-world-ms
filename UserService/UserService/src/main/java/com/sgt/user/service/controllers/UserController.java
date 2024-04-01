package com.sgt.user.service.controllers;

import com.sgt.user.service.entities.User;
import com.sgt.user.service.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.ws.rs.PUT;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final String USER_SERVICE_CB = "userServiceCircuitBreaker";
    @Autowired
    private UserService userService;

    //create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    // get Single user
    @GetMapping("/{userId}")
    @CircuitBreaker(name = USER_SERVICE_CB, fallbackMethod = "singleUserRatingsFallBackMethod")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
        User requestedUser = userService.getUserById(userId);
        return ResponseEntity.ok(requestedUser);
    }
    // get All user
    @GetMapping
    @CircuitBreaker(name = USER_SERVICE_CB, fallbackMethod = "allUsersRatingsFallBackMethod")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUserList = userService.getAllUsers();
        return ResponseEntity.ok(allUserList);
    }

    public ResponseEntity<User> singleUserRatingsFallBackMethod(String userId, Exception exception){
        return  ResponseEntity.ok(userService.singleUserRatingsFallBackMethod(userId, exception));
    }

    public ResponseEntity<List<User>> allUsersRatingsFallBackMethod(Exception exception){
        return  ResponseEntity.ok(userService.allUsersRatingsFallBackMethod(exception));
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

}
