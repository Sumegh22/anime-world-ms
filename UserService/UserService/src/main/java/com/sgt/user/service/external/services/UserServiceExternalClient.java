package com.sgt.user.service.external.services;

import com.sgt.user.service.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient
public interface UserServiceExternalClient {

    @GetMapping("/users/{userId}")
    User getUserById(@PathVariable("userId") String userId);

    @GetMapping("/users")
    ResponseEntity<List<User>> getAllUsers();

    ResponseEntity<User> createNewUser(User newUser);

    @PutMapping("/users/{userId}")
    ResponseEntity<User> updateUser(@PathVariable("userId") String userId, User newValues);

}

